package com.sparsearray;

import java.util.Arrays;

/**
 * 
 * 稀疏数组：
 * 当一个数组中大部分元素为0，或者为同一个值的数组时,
 * 可以使用稀疏数组来保存该数组,使用稀疏数组最主要的目的是节省磁盘空间
 *
 * @author god
 */
public class SparseArray {

    public static void main(String[] args) {
        // 需求：解决五子棋存盘和继续下棋功能

        // ----------------下棋----------------
        // 1.初始化棋盘
        int[][] init = new int[11][11];
        // 2.下棋  1:白子  2:黑子
        init[1][2] = 1;
        init[2][3] = 2;
        // 3.打印棋盘
        for (int[] row : init){
            for (int data : row){
                System.out.print(data+"   ");
            }
            System.out.println();
        }

        // ----------------存盘----------------
        // 1.获取棋子的个数
        int sum = 0;
        for (int[] row : init){
            for (int data : row){
                if(data != 0) {
                    sum ++;
                }
            }
        }
        System.out.println("棋子个数为："+sum);

        // 2.将棋盘信息存储到稀疏数组
        // 2.1定义稀疏数组
        int[][] sparse = new int[sum+1][3];

        // 2.2存储棋盘的行、列、棋子个数
        sparse[0][0] = init.length;
        sparse[0][1] = init.length;
        sparse[0][2] = sum;

        // 2.2循环棋盘，存储棋子所在的行、列、值
        int index = 1;
        for(int i = 0; i < init.length; i++){
            for(int j = 0; j < init.length; j++){
                if(init[i][j] !=0){
                    sparse[index][0] = i;
                    sparse[index][1] = j;
                    sparse[index][2] = init[i][j];
                    index ++;
                }
            }
        }

        // 3. 打印稀疏数组，查看棋盘信息
        for (int[] row : sparse){
            System.out.println(Arrays.toString(row));
        }

        /*
         说明：
         原始棋盘存储的值为 11 * 11
         稀疏数组存储的值为 3 * 3
         通过对比可以发现，存储的数据减少很多，这样做的目的能够节省空间
         */

        // ----------------继续下棋----------------

        // 1.创建棋盘
        int[][] newInit = new int[sparse[0][0]][sparse[0][1]];

        // 2.初始化棋子
        for(int i = 1; i <= sum; i++){
            // 棋子所在的行
            int row = sparse[i][0];
            // 棋子所在的列
            int column = sparse[i][1];
            // 棋子值
            int value = sparse[i][2];

            // 放入棋盘
            newInit[row][column] = value;
        }

        // 3.打印棋盘
        for (int[] row : newInit){
            for (int data : row){
                System.out.print(data+"   ");
            }
            System.out.println();
        }

    }

}
