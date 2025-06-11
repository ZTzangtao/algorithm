package own_test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DelNumMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numLength = sc.nextInt();
        String str = sc.nextLine();
        String str1 = sc.nextLine();
        Integer[] arr = new Integer[numLength];
        if (str1 != null && !str1.isEmpty()) {
            String[] temp = str1.split(" ");
            for (int i = 0; i < temp.length; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }
            Arrays.sort(arr, Collections.reverseOrder());
            int num = 0;
            while (arr[1] > 0 && num <= arr.length * arr.length) {
                for (int i = 1; i < arr.length && arr[i] >= 1; i++) {
                    if (arr[i - 1] == arr[i]) {
                        arr[i - 1]  = -1;
                        arr[i] = 2 * arr[i];
                    }
                    Arrays.sort(arr, Collections.reverseOrder());
                    num++;
                }
            }
            System.out.println("result=" + arr[0]);

        }
    }

    
}
