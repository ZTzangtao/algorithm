package own_test;

import java.util.concurrent.locks.LockSupport;

public class AlternatePrint1 {

    static Thread t1 = null, t2 = null;

    /**
     *  交替打印     2个线程 一个线程输出123... 另一个线程输出 abc...
     *
     * @param args
     */
    public static void main(String[] args) {
        char[] num = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] ch = {'A','B','C','D','E','F','G','H','J'};
        t1 = new Thread(() -> {
            for (char n : num) {
                System.out.print(n);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : ch) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();
    }





}
