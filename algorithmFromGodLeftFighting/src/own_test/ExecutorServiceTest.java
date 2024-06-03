package own_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest implements Runnable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ExecutorServiceTest());
    }

    @Override
    public void run() {
        System.out.println("hello Executors");

    }
}
