package alg;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //Uncomment the following to pipe an input file into the standard input
    
//    try {
//      FileInputStream is = new FileInputStream(new File("/Users/jake/Downloads/datapub/pub04.in"));
//      System.setIn(is);
//    } catch (FileNotFoundException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    
    //read in user input and solve
    Scanner in = new Scanner(System.in);
    short n = in.nextShort();
    System.out.println(Main.solve(in, n));
    in.close();
  }
  
  public static int solve(Scanner in, short n) {
    int[][] m = Helpers.computeSumTable(in, n);
    short r = Helpers.getSmallestRow(m);
    return Main.findASolution(m, r);
  }
  
  public static int findASolution(int[][] m, short r) {
    //find top value
    short n = (short)(m[0].length-1);
    int smallestTop = Integer.MAX_VALUE;
    short smallestTopIndex = -1;
    for (short x = 0; x < n; x++) {
      int difference = Math.abs(2 * m[x][r] - m[n][r]);
      if ( difference < smallestTop ) {
        smallestTop = difference;
        smallestTopIndex = x;
      }
    }
    
    //find bottom value
    int smallestBottom = Integer.MAX_VALUE;
    short smallestBottomIndex = -1;
    for (short x = 0; x < n; x++) {
      int right = m[n][n] - m[n][r];
      int left = m[x][n] - m[x][r];
      int difference = Math.abs(2 * left - right);
      if ( difference < smallestBottom ) {
        smallestBottom = difference;
        smallestBottomIndex = x;
      }
    }
    
//    System.out.println("row => " + r + "   ;  top => " + smallestTopIndex + "   ;    bot => " + smallestBottomIndex);
    return Helpers.summedDifference(m, smallestTopIndex, smallestBottomIndex, r);
  }
}
