package multiThread.basics;

public class MiTest {
    /**
     * 线程强占  join
     * 如果在main线程中调用了t1.join()，那么main线程需要等待t1全部执行完毕，main线程进入到等待状态，再恢复到就绪状态等待cpu调度
     * 如果main线程中调用了t1.join(2000)，那么main线程会进入到等待状态，需要等待t1执行2s后，再恢复到就绪状态等待cpu调度，如果在等待期间
     * t1已经结束了，那么main线程自动变为就绪状态，等待cpu调度
     *
     *  守护线程
     *  默认情况下，线程都是非守护线程
     *  JVM会在程序中没有非守护线程时，结束掉当前JVm
     *  主线程默认是非守护线程，如果主线程执行结束，需要查看当前jvm内是否还有非守护线程，如果没有，jvm直接停止
     *
     *
     * @param args
     * @throws InterruptedException
     */


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("t1:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("t2:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (i == 1) {
                //
                t1.join(2000);
            }
        }


    }

}
