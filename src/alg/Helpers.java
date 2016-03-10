package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Helpers {

  public static int[][] computeSumTable(Scanner in, short n) {
    int[][] matrix = new int[n][n];

    int xSum = 0;
    for(int x = 0; x < n; x++) {
      xSum += in.nextInt();
      matrix[x][0] = xSum;
    }
    
    for(int y = 1; y < n; y++) {
      xSum = 0;
      for(int x = 0; x < n; x++) {
        xSum += in.nextInt();
        matrix[x][y] = xSum;
        matrix[x][y] += matrix[x][y-1];
      }
    }

    return matrix;
  }
  
  // I think, mathematically, this is irrelevant (having more than one row that is equal in size)
  @Deprecated
  public static ArrayList<Short> getSmallestRows(int[][] m) {
    ArrayList<Short> rows = new ArrayList<Short>();
    short n = (short)(m[0].length-1);
    int smallestDifference = Integer.MAX_VALUE;
    for (short r = 0; r < n; r++) {
      int difference = m[n][n] - m[n][r];
      if(difference < smallestDifference) {
        rows = new ArrayList<Short>();
        rows.add(r);
        smallestDifference = difference;
      } else if (difference == smallestDifference) {
        rows.add(r);
      }
    }
    return rows;
  }
  
  public static short getSmallestRow(int[][] m) {
    short row = -1;
    short n = (short)(m[0].length-1);
    int smallestDifference = Integer.MAX_VALUE;
    for (short r = 0; r < n; r++) {
      int difference = Math.abs(m[n][n] - 2 * m[n][r]);
      if(difference < smallestDifference) {
        row = r;
        smallestDifference = difference;
      }
    }
    return row;
  }
  
  public static int summedDifference(int[][] matrix, short topX, short botX, short row) {
    int n = matrix[0].length-1;
    int sums[] = new int[4];
    sums[1] = matrix[topX][row];
    sums[0] = matrix[n][row] - sums[1];
    sums[2] = matrix[botX][n] - matrix[botX][row];
    sums[3] = matrix[n][n] - sums[0] - sums[2] - sums[1];
    Arrays.sort(sums);
    return sums[3]-sums[0];
  }
}
