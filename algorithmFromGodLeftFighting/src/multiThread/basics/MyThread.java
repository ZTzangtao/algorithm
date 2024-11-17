package multiThread.basics;

/**
 * @Author Tommy
 * @Date 2024/11/3 12:14
 * @Version 1.0
 */
public class MyThread {


    /**
     * blocked: synchronized没有拿到同步锁，被阻塞
     * runnable thread对象调用了start方法 就为runnable状态
     * waiting：调用wait方法就会处于waiting状态，需要被手动唤醒
     * time_waiting: 调用sleep方法或者join方法，会被自动唤醒，无需手动唤醒
     * terminated：run方法执行完毕，线程生命周期到头了
     *
     * 线程设置名字 t1.setName("模块-功能-计数器")
     * 线程的优先级，就是线程调度的优先级
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        Object obj = new Object();

        Thread t1 = new Thread(() -> {

            /**
             * TERMINATED
             */
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            /**
             * TIMED_WAITING
             */
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }


            /**
             * WAITING
             */
//            synchronized (obj) {
//                try {
//                    obj.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }

            /**
             * RUNNABLE
             */
//            while (true) {
//
//            }

            /**
             * BLOCKED
             */
//            synchronized (obj) {
//
//            }



        });
        t1.start();
        Thread.sleep(500);
        System.out.println(t1.getState());
        /**
         * BLOCKED
         */
//        synchronized (obj) {
//            t1.start();
//            Thread.sleep(500);
//            System.out.println(t1.getState());
//        }


    }


}
