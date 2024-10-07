import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Tommy
 * @Date 2024/8/19 15:40
 * @Version 1.0
 */
public class Test2 {

    /**
     *  Suppose we have a class:
     * public class Foo {
     *   public void a() { print("first"); }
     *   public void b() { print("second"); }
     *   public void c() { print("third"); }
     * }
     * The same instance of Foo will be passed to three different threads. Thread-a will call a(), thread-b will call b(), and thread-c will call c().
     * Design a mechanism and modify the program to ensure that b() is executed after a(), and c() is executed after b().
     */
    static Thread t1 = null, t2 = null , t3 = null;

    public static void main(String[] args) {
        Foo foo = new Foo();

        final Lock lock = new ReentrantLock();

        final Object object = new Object();

        t1 = new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               synchronized (object) {
                   foo.a();
                   object.notify();
                   try {
                       object.wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
           }
        }, "t1");

        t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (object) {
                    foo.b();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    object.notify();
                }
                lock.unlock();
            }
        }, "t2");

        t3 = new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               synchronized (object) {
                   lock.lock();
                   foo.c();
                   try {
                       object.wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   object.notify();
               }
           }
       }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
