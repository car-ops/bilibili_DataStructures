package com.atguigu.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 6, 1 ,3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //分+合
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param right 右边索引
     * @param mid 中间索引
     * @param temp 中转数组
     */
    //合并
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left;//初始化i,左边有序序列的初始值
        int j = mid + 1;//初始化j,右边有序序列的初始索引
        int t = 0;//指向temp当前索引
        //先把左右2边（有序）的数据按规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完为止
        while (i <= mid && j <= right) {//继续
            //如果左边的有序序列的当前元素，小于等于有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组中去
            //然后t++,i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }

        }

        //把剩余数据的一边数据一次填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //将temp数组拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
