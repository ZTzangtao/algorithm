package multiThread.basics;

public class MiTestYield {

    /**
     * 可以通过Thread的静态方法yield，让当前现成从运行状态转变为就绪状态
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i == 50) {
                    Thread.yield();
                }
                System.out.println("t1:" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t2:" + i);
            }
        });
        t2.start();
        t1.start();
    }

}
