/**
 * @Author Tommy
 * @Date 2024/8/19 15:42
 * @Version 1.0
 */
public class Foo {

    /**
     * ensure that b() is executed after a(), and c() is executed after b().
     */
    public void a() {
        print("first");
    }

    public void b() {
        print("second");
    }

    public void c() {
        print("third");
    }

    public void print (String s) {
        System.out.println(s);
    }

}
