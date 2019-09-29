package com.atguigu.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int inserIndex = i - 1;//arr[1]的前面这个数的下标

            while (inserIndex >= 0 && insertVal < arr[inserIndex]) {
                arr[inserIndex + 1] = arr[inserIndex];
                inserIndex--;
            }
            if (inserIndex + 1 != i) {
                arr[inserIndex + 1] = insertVal;
            }
        }
    }
}
