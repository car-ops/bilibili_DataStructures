package com.atguigu.recursion;

import java.util.Map;

public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array,保存皇后放置位置的结果
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        //测试一把，8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    //编写一个方法，放置第n个皇后
    //特别注意：check是每一次递归时，进入check都有for循环，因此会有回溯
    private void check(int n) {
        if (n == max) {//n=8，其实前8个皇后已经放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n,放在改行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //接着放n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i;即将第n个皇后，放置本行得后移得一个位置
        }
    }

    //查看当我们放置第n个皇后的时候，就去检测该皇后是否和前面已经摆放的皇后冲突
    //n表示放第n个皇后
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置打印出来
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
