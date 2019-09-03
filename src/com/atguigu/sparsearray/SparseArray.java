package com.atguigu.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        System.out.println("原始的二维数组");
        for (int[] row: chessArr1) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("得到的稀疏数组为：");
        for (int[] row: sparseArr) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row: chessArr2) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }
}
