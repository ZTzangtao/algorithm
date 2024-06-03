package own_test;

public class RunnableTest implements Runnable {

    public static void main(String[] args) {

        Thread thread = new Thread(new RunnableTest());
        thread.start();
    }


    @Override
    public void run() {
        System.out.println("zt");
    }
}
