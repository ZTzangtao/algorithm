package own_test;

import java.util.LinkedList;
import java.util.Scanner;

public class ExceptionTest {

    public static void aMethod (int i) {
        try {
            int a = 10 / i;
        }catch (Exception ex){
            System.out.println(11);
        } finally {
            System.out.println("fin");
        }

    }

    public static void main(String[] args) {
//        try {
//            aMethod(0);
//        } catch (Exception ee){
//            System.out.println("ee");
//        }

        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for(int i=0; i<t; i++)
        {
            int n = cin.nextInt();
            LinkedList<Integer> queue = new LinkedList<Integer>();

            for(int j= n; j>0; j--)
            {
                queue.addFirst(j);
                queue.addFirst(queue.removeLast());
            }
            for(int p=0; p<n-1; p++)
            {
                System.out.print(queue.get(p)+" ");
            }
            System.out.println(queue.get(n-1));

        }
        cin.close();

    }





}
