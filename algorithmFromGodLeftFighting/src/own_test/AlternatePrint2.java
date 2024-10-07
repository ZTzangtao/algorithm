package own_test;

public class AlternatePrint2 {

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
            }
        }, "t1");

        t2 = new Thread(() -> {
            synchronized (o) {
                for (char c : ch) {
                    System.out.print(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "t2");

//        new Thread(() -> {
//            synchronized (o) {
//                for (char c : ch) {
//
//                    System.out.print(c);
//                    o.notify();
//                    try {
//                        o.wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        }, "t3").start();

        t1.start();
        t2.start();

}
}
