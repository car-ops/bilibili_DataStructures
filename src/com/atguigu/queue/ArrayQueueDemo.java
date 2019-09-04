package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户的输入
        Scanner scanner= new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.printf("s(show)：显示队列\n");
            System.out.printf("e(exit)：退出程序\n");
            System.out.printf("a(add)：添加数据到队列\n");
            System.out.printf("g(get)：从队列中取数据\n");
            System.out.printf("h(head)：查看队列头的数据\n");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("去除的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("程序退出~~");
    }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arraySize) {
        maxSize = arraySize;
        arr = new int[maxSize];
        front = -1;//指向头部,分析出front是指向队列头的前一个位置
        rear = -1;//指向尾部，队列最后一个数据
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;//让rear后移
        arr[rear] = n;
    }
    //获取队列数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if(isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
    //显示队列的头数据，注意不是取数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front+1];
    }
}
