package ownWriteDemo;

/**
 * @Author: Tommy
 * @DATE: 2023/3/8
 */
public class KMPDemo {

    public static void main(String[] args) {
        System.out.println(kmp("gwregwtgwthfergwrgwerg","ergwrgwerg"));
    }

    public static int kmp (String s1, String s2){
        if( s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s2.length() > s1.length() ) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] nextArray = getNextArray(str2);
        while (i1 < str1.length &&  i2 < str2.length) {
            if(str1[i1] == str2[i2]) {
                i1++;
                i2++;
            }else if (nextArray[i2] == -1){
                i1++;
            } else {
                i2 = nextArray[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] str2) {
        if (str2.length <= 1) {
            return new int[] { -1 };
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (str2[i - 1 ] == str2[cn] ) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

}
