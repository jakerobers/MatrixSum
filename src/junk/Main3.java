package junk;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    short n = in.nextShort();
    int[][] summedMatrixTable = computeSumTable(in, n);
    short r = findRow(summedMatrixTable);
    short t = findTop(summedMatrixTable, r);
    short b = findBottom(summedMatrixTable, r);
    System.out.println(summedDifference(summedMatrixTable, t, b, r));
    in.close();
  }

  public static short findBottom(int[][] matrix, short y) {
    int smallestDifference = Integer.MAX_VALUE;
    short c = -1;
    short n = (short)(matrix[0].length-1);
    for (short x = 0; x < n; x++) {
      int difference = Math.abs(matrix[n][y] - matrix[x][y]);
      if (difference < smallestDifference) {
//        System.out.println(difference + "=>" + smallestDifference + "(" + x + ")");
        smallestDifference = difference;
        c = x;
      }
    }
    return c;
  }

  public static short findTop(int[][] matrix, short y) {
    int smallestDifference = Integer.MAX_VALUE;
    short c = -1;
    short n = (short)(matrix[0].length-1);
    for (short x = 0; x < n; x++) {
      int difference = Math.abs(matrix[n][y-1] - matrix[x][y-1]);
      if (difference < smallestDifference) {
        smallestDifference = difference;
        c = x;
      }
    }
    return c;
  }

  public static int[][] computeSumTable(Scanner in, short n) {
    int[][] matrix = new int[n][n];

    for(int y = 0; y < n; y++) {
      int xSum = 0;
      for(int x = 0; x < n; x++) {
        xSum += in.nextInt();
        matrix[x][y] = xSum;
        if (y != 0) {
          matrix[x][y] += matrix[x][y-1];
        }
      }
    }

    return matrix;
  }

  public static short findRow(int[][] matrix) {
    short r = -1;
    short n = (short)(matrix[0].length-1);
    int smallestDifference = Integer.MAX_VALUE;
    for (short y = 1; y < n; y++) {
      int difference = Math.abs(matrix[n][n] - matrix[y][n]); 
      if (difference < smallestDifference) {
        smallestDifference = difference;
        r = y;
      }
    }
    return r;
  }
  
  public static int summedDifference(int[][] matrix, short topX, short botX, short row) {
    int n = matrix[0].length-1;
    int sums[] = new int[4];
    System.out.println("topX:" + topX);
    System.out.println("row:" + row);
    sums[1] = matrix[topX-1][row-1];
    sums[0] = matrix[row-1][n] - sums[1];
    sums[2] = matrix[n][botX] - matrix[row-1][botX];
    System.out.println(matrix[n][botX] + " - " + matrix[row-1][botX] + "=" + sums[2]);
    sums[3] = matrix[n][n] - sums[0] - sums[2] - sums[1];
    System.out.println(Arrays.toString(sums));
    Arrays.sort(sums);
    return sums[3]-sums[0];
  }
}
