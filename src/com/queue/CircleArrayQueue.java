package com.queue;

import java.util.Scanner;

/**
 *
 * 数组模拟环形队列：可以复用
 * @author god
 *
 */
public class CircleArrayQueue {


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


    public CircleArrayQueue(int maxSize){
        // 数组容量
        this.maxSize = maxSize;

        // 初始化数组
        arr = new int[maxSize];

        // rear front 初始化为 0
        // 由于Java中int类型默认值为0，所以不需要初始化
        // rear = front = 0;
    }

    public boolean isFull(){
        // 这里的 +1 为了能够实现取余计算，以达到数组下标越界后从0开始继续循环
        // 如何判断队列已满？
        // 很简单，(rear+1)的下一个下标是front就表示队列已满
        return (rear+1) % maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }


        // 这里的 rear通过取余来动态计算值，初始化的值为 0
        arr[rear] = n;

        // 通过取余，rear的值可以在 [0 - maxSize] 之间依次循环出现
        rear = (rear+1) % maxSize;
    }

    public void getQueue(){

        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }

        // 这里的 front通过取余来动态计算值，初始化的值为 0
        System.out.println(arr[front]);

        // 通过取余，front的值可以在 [0 - maxSize] 之间依次循环出现
        front = (front+1) % maxSize;
    }

    public void headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        System.out.println(this.arr[front]);
    }

    public void showQueue(){

        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }

        // 1.计算出当前队列中有效数据的个数
        /*
          rear = 2
          front = 0
          maxSize = 3
          sum = (2 + 3 - 0) % 3
          sum = 5 % 3
          sum = 2
          有效个数为 2
          ------------------------------
          rear = 0
          front = 2
          maxSize = 3
          sum = (0 + 3 - 2) % 3
          sum = 1 % 3
          sum = 1
          有效个数为 1
         */
        int sum = (rear+maxSize-front)%maxSize;

        // 2.从front开始循环，循环sum次
        for(int i = front;i<front+sum; i++){
            // 通过取余，实现数组下标越界后从 0 开始
            // 3 % 3 = 0
            // 4 % 3 = 1
            System.out.print(arr[ i % maxSize]);
        }
    }




    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
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
