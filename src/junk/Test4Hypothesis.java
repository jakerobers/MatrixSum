package junk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4Hypothesis {
  public static void main(String[] args) {
    try {
      FileInputStream is = new FileInputStream(new File("/Users/jake/Downloads/datapub/pub04.in"));
      System.setIn(is);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    Scanner in = new Scanner(System.in);
    
    int n = in.nextInt();
    System.out.println(n);
    int[][] m = new int[n][n]; 
    
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        m[x][y] = in.nextInt();
      }
    }
    
    int upperLeft = 0;
    for(int y = 0; y <= 221; y++) {
      for(int x = 0; x <= 149; x++) {
        upperLeft += m[x][y];
      }
    }
    
    int upperRight = 0;
    for(int y = 0; y <= 221; y++) {
      for(int x = 150; x < n; x++) {
        upperRight += m[x][y];
      }
    }
    
    int lowerLeft = 0;
    for(int y = 222; y < n; y++) {
      for(int x = 0; x <= 498; x++) {
        lowerLeft += m[x][y];
      }
    }
    
    int lowerRight = 0;
    for(int y = 222; y < n; y++) {
      for(int x = 499; x < n; x++) {
        lowerRight += m[x][y];
      }
    }
    
    System.out.println(upperLeft + " " + upperRight + " " + lowerLeft + " " + lowerRight);
  }
}
