package GettingStart;


/**
 * 二进制和位运算
 * Binary and bitwise operations
 *
 */
public class BinaryAndBitwiseOperations {
    // 打印一个int类型的数字，32位进制的状态
    // 左侧是高位，右侧是低位
    public static void printBinary(int a) {
        for(int i = 31; i >= 0; i-- ) {
            System.out.print((a & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 0b0110;
        System.out.println(a);
        printBinary(a);

    }

}
