package alg;

public class RowRunnable implements Runnable {

  int[][] m;
  int[] bounds;
  int[] incr;
  
  /**
   * Creates a runnable thread for processing the sum matrix table
   * @param m The sum matrix table
   * @param bounds The bounds to process on
   * @param incr The values to be incremented
   */
  public RowRunnable(int[][] m, int[] bounds, int[] incr) {
    this.m = m;
    this.bounds = bounds;
    this.incr = incr;
  }
  
  @Override
  public void run() {
    
  }
}
