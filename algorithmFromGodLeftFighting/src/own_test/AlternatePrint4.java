package own_test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrint4 {

    static Thread t1 = null, t2 = null;


    /**
     *  交替打印     2个线程 一个线程输出123... 另一个线程输出 abc...
     *
     * @param args
     */
    public static void main(String[] args) {

        Lock lock = new ReentrantLock(); // 替代sync
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        CountDownLatch latch = new CountDownLatch(1);

        char[] num = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] ch = {'A','B','C','D','E','F','G','H','J'};
        t1 = new Thread(() -> {

            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.lock();


            for (char n : num) {
                System.out.print(n);
                condition2.signal();
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            condition2.signal();
            lock.unlock();
        }, "t1");

        t2 = new Thread(() -> {
            lock.lock();

            for (char c : ch) {
                System.out.print(c);
                latch.countDown();
                condition1.signal();

                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            condition1.signal();
            lock.unlock();
        }, "t2");
        t1.start();
        t2.start();
    }

}
