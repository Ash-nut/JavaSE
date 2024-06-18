package cn.helloworld1999;

public class Exercises3 {
    public static void main(String[] args) {
        exercise4();
    }

    static void exercise1() {
        int sum = 0;
        int arr[] = new int[100];
        for (int i = 0; i <= arr.length; i++) {
            arr[i] = i + 1;
            System.out.println(arr[i]);
        }
        for (int i = 0; i <= 99; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            } else {
                continue;
            }
        }
        System.out.println("sum= " + sum);
    }

    static void exercise2() {
        int arr[] = { 23, 45, 673, 76, 2, 87, 1 };
        int min = arr[0];
        for (int i : arr) {
            min = i > min ? min : i;
        }
        System.out.println("min = " + min);
    }

    // 似乎写错了，但是错在哪了呢？
    static void exercise3() {
        int arr[] = { 23, 45, 673, 76, 2, 87, 1 };
        boolean bo = false;
        while (bo) {
            for (int i = 0; arr[i] > arr[i + 1]; i++) {
                arr[i] = arr[i + 1];
                if (i == arr.length) {
                    bo = true;
                    for (int a : arr) {
                        System.out.print(i + " ");
                    }
                }
                i = i >= arr.length - 1 ? 0 : i;
            }
        }
    }

    static void exercise4() {
        String name[] = new String[] { "倩倩", "刘亦菲", "zsl", "lucy" };
        String name1[] = new String[name.length + 1];
        for (int i = 0; i < name.length; i++) {
            name1[i] = name[i];
        }
        name1[name.length] = "小尾巴";
        name = name1;
        for (String str : name) {
            System.out.println(str);
        }
    }
    static void exercise5(){
        String name[] = new String[] { "倩倩", "刘亦菲", "zsl", "lucy" };
    }
}