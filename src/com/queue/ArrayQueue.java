package com.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 数组模拟队列：无法复用
 * @author god
 */
public class ArrayQueue {

    /**
     * 队列构造器
     */
    public ArrayQueue(int maxSize){
        // 数组容量
        this.maxSize = maxSize;
        // 初始化数组
        arr = new int[maxSize];
        // 设置头部和尾部的下标
        front = rear = -1;

    }
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return front == rear;
    }


    public void addQueue(int n){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        this.arr[rear] = n;
    }

    public void getQueue(){

        // 判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        System.out.println(this.arr[++front]);

    }

    public void showQueue(){
        if(this.isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        System.out.println(Arrays.toString(this.arr));
    }

    public void headQueue(){
        if(isEmpty()){
            System.out.println("队列为空！");
            return;
        }

        if(rear == front){
            System.out.println("队列为空！");
            return;
        }

        System.out.println(this.arr[front+1]);
    }

    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 队列头部索引
     */
    private int front;

    /**
     * 队列尾部索引
     */
    private int rear;

    /**
     * 存放数据
     */
    private int[] arr;



    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s：显示队列");
            System.out.println("e：退出程序");
            System.out.println("a：添加数据到队列");
            System.out.println("g：从队列取出数据");
            System.out.println("h：查看队列头的数据");

            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    queue.getQueue();
                    break;
                case 'h':
                    queue.headQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序结束");
    }

}
