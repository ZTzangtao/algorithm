package own_test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Tommy
 * @Date 2024/6/8 16:26
 * @Version 1.0
 */

public class ThreadLocalTest {

    static class MyTask {
        // 创建一个10m的数组  1M = 1024 * 1024
        private byte[] bytes = new byte[1024 * 1024 * 10];

    }

    private static ThreadLocal<MyTask> taskThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        for (int i = 0; i < 10; i++) {
            executeTask(threadPoolExecutor);
            Thread.sleep(1000);

        }
    }

    private static void executeTask(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建对象");
                // 创建对象10M
                MyTask myTask = new MyTask();
                // 存储 ThreadLocal
                taskThreadLocal.set(myTask);
                // 将对象设置成null，表示此对象不再使用了
                myTask = null;
            }
        });
    }


}
