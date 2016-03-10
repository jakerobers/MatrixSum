package spec;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Test;

import alg.Main;
import junk.Main3;

public class MainSpec {
  
  public void simpleTest() {
    Scanner in = new Scanner("1 2  3\n4  5 6\n7 8 9");
    short n = 3;
    int[][] summedMatrixTable = Main3.computeSumTable(in, n);
    System.out.println(summedMatrixTable);
  }

  @Test
  public void publicOne() {
    Scanner in = new Scanner("3   0   2  -8  -8\n5   3   2   2   3\n2   5   2   1   4\n3   4  -1   4   2\n-3   6   2   4   3");
    short n = 5;
    assertEquals(5, Main.solve(in, n));
  }
  
  @Test
  public void publicTwo() {
    Scanner in = new Scanner("1  2  3   4   5   6\n2  4  6   8  10   8\n3  6  9  12   9   6\n4  8 12   8   4   0\n5 10  5   0  -5 -10\n6  0 -6 -12 -18 -24");
    short n = 6;
    assertEquals(16, Main.solve(in, n));
  }

  @Test
  public void publicThree() {
    Scanner in = new Scanner("100 -1 -2 -3 -4 -5 -6 -7\n-1 -1 -1 -1 -1 -1 -1 -1\n-1 -1 -1 -1 -1 -1 -1 -1\n-1 -1 -1 -1 -1 -1 -1 -1\n-1 -1 -1 -1 -1 -1 -1 -1\n-1 -1 -1 -1 -1 -1 -1 -1\n-1 -1 -1 -1 -1 -1 -1 -1\n30 -1 -1 -1 -1 -1 -1 -30");
    short n = 8;
    assertEquals(67, Main.solve(in, n));
  }
  
  public static String readFile(String path) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, StandardCharsets.UTF_8);
  }
}

