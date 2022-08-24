package com.atguigu.sparsearray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将棋盘保存到本地
 * 从本地加载上次保存的棋盘
 *
 * @author jiangjunhe
 */
public class LocalFileVSMemory {

    public static void toLocalFile(String path) {
        //initialize 11*11 chessboard
        int[][] chessArray = new int[11][11];
        chessArray[1][3] = 1;
        chessArray[5][6] = 1;
        chessArray[7][6] = 2;
        printChessboard(chessArray);
        //stored as sparse array
        int[][] spareArray = translateToSparseArray(chessArray);
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(convertIntArrayToByteArray(spareArray, 3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fileOutputStream);
        }
    }

    /**
     * cut to separated row array byte[]
     *
     * @return
     */
    public static byte[] convertIntArrayToByteArray(int[][] sparseArray, int row) {
        int byteNum = row * 3 * 4;
        byte[] result = new byte[byteNum];
        for (int r = 0; r < row; r++) {
            int[] rowArray = sparseArray[r];
            byte[] rowByteArray = convertIntArrToByteArr(rowArray);
            for (int b = 0; b < rowByteArray.length; b++) {
                result[r * row + b] = rowByteArray[b];
            }
        }
        return result;
    }

    public static int[][] covertByteArrayToSparseArray(byte[] bytes) {
        int row = bytes.length / 4 / 3;
        int[][] sparseArray = new int[1][row];
        //12 bytes as single []
        for (int r = 0; r < row; r++) {
            //cut part
            int[] byteArr = new int[3];
            byte[] byteTemp = new byte[12];
            for (int begin = r * 12; begin < (r + 1) * 12; begin++) {
            }
        }
        return sparseArray;
    }

    public int[] convertByteArrToIntArr(byte[] byteArr) {
        int remained = 0;
        int intNum = 0;
        remained = byteArr.length % 4;
        if (remained != 0) {
            throw new RuntimeException();
        }
        intNum = byteArr.length / 4;
        int[] intArr = new int[intNum];

        int ch1, ch2, ch3, ch4;
        for (int j = 0, k = 0; j < intArr.length; j++, k += 4) {
            ch1 = byteArr[k];
            ch2 = byteArr[k + 1];
            ch3 = byteArr[k + 2];
            ch4 = byteArr[k + 3];
            if (ch1 < 0) {
                ch1 = 256 + ch1;
            }
            if (ch2 < 0) {
                ch2 = 256 + ch2;
            }
            if (ch3 < 0) {
                ch3 = 256 + ch3;
            }
            if (ch4 < 0) {
                ch4 = 256 + ch4;
            }
            intArr[j] = (ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0);
        }
        return intArr;
    }

    public static byte[] convertIntArrToByteArr(int[] intArr) {
        int byteNum = intArr.length * 4;
        byte[] byteArr = new byte[byteNum];
        int curInt = 0;
        for (int j = 0, k = 0; j < intArr.length; j++, k += 4) {
            curInt = intArr[j];
            byteArr[k] = (byte) ((curInt >>> 24) & 0xFF);
            byteArr[k + 1] = (byte) ((curInt >>> 16) & 0xFF);
            byteArr[k + 2] = (byte) ((curInt >>> 8) & 0xFF);
            byteArr[k + 3] = (byte) ((curInt >>> 0) & 0xFF);
        }
        return byteArr;
    }

    public static void closeStream(FileOutputStream fileOutputStream) {
        try {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    public static int[][] translateToSparseArray(int[][] chessArray) {
        //traverse chessArray,record chess sum
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        //make a sparse array
        int[][] spareArray = new int[sum + 1][3];
        //first row as meta row
        //store chessboard row
        spareArray[0][0] = 11;
        //store chessboard column
        spareArray[0][1] = 11;
        //store total cheese nums
        spareArray[0][2] = sum;

        //put chess num into sparse array
        int whichOne = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    whichOne++;
                    //store row
                    spareArray[whichOne][0] = i;
                    //store column
                    spareArray[whichOne][1] = j;
                    //store value which is on behalf of chess
                    spareArray[whichOne][3] = chessArray[i][j];
                }
            }
        }
        return spareArray;
    }

    public static void printChessboard(int[][] chessArray) {
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    public static int[][] loadToMemory(String path) {

        return null;
    }

    public static void main(String[] args) {
        toLocalFile("");
    }
}
