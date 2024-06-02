package own_test;

import java.util.concurrent.CountDownLatch;

public class AlternatePrint3 {

    private static CountDownLatch latch = new CountDownLatch(1);

    static Thread t1 = null, t2 = null;

    /**
     *  交替打印     2个线程 一个线程输出123... 另一个线程输出 abc...
     *
     * @param args
     */
    public static void main(String[] args) {

        final Object o = new Object();

        char[] num = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] ch = {'A','B','C','D','E','F','G','H','J'};
        t1 = new Thread(() -> {

            try {
                latch.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (o) {
                for (char n : num) {
                    System.out.print(n);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                o.notify();
            }

        }, "t1");

        t2 = new Thread(() -> {

            synchronized (o) {
                for (char c : ch) {

                    System.out.print(c);
                    latch.countDown();
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            o.notify();

        }, "t2");
        t1.start();
        t2.start();

    }

}
