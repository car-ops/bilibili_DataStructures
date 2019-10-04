package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        shellSort2(arr);
    }

    //使用逐步推导的方式，来编写shell排序，交换式的shell排序
    public static void shellSort(int[] arr) {
        //根据前面的分析，使用循环处理
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（每组，2个元素）
                for (int j = i - gap; j >= 0; j-= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //对交换式的shell排序进行优化->移位法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap > 0 && arr[j] < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
