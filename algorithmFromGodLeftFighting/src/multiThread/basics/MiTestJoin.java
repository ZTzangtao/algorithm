package multiThread.basics;

public class MiTestJoin {

    /**
     * 在main线程中调用了t1.join(),那么main线程会进入到等待状态，需要等待t1线程全部执行完毕，再恢复到就绪状态等待CPU调度。
     * 在main线程中调用了t1.join(2000),那么main线程会进入到等待状态，需要等待t1执行2秒后，再恢复到就绪状态等待CPU调度。
     * 如果在等待期间，t1已经结束了
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t1:" + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t2:" + i);
            }
        });
        t2.start();
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main" + i);
            Thread.sleep(1000);
            if (i == 1) {
                t1.join(2000);
            }
        }


    }

}
