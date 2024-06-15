package cn.helloworld1999;

import java.util.Arrays;

/**
 * 数组反转
 * 改好了
 */

public class InversionArray {
    public static void main(String[] args) {
        demo();
    }

    static int[] arr = { 28, 11, 22, 7, 15, 9, 16 };

    static void demo() {
        for (int i = 0; i <= arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}
