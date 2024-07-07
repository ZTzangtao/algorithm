package own_test;

public class ThreadLocalMapTest {


    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("ss");

        System.out.println(threadLocal.get());
    }
}
