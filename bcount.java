import java.util.*;
import java.io.*;

public class bcount{
  public static void main(String[] args)throws IOException{
    Scanner sc = new Scanner(new File("bcount.in"));
    PrintWriter out = new PrintWriter(new File("bcount.out"));
    int N = sc.nextInt();
    int M = sc.nextInt();
    
    int[][] counts = new int[N+1][3];
    
    int H = 0;
    int G = 0;
    int J = 0;
    
    for(int i = 0; i< N; i++){
      int curr = sc.nextInt();
      if(curr == 1)
        H++;
      if(curr == 2)
        G++;
      if(curr == 3)
        J++;
      
      counts[i+1][0] = H;
      counts[i+1][1] = G;
      counts[i+1][2] = J;
    }
    
    for(int i = 0; i<M; i++){
      int first = sc.nextInt();
      int second = sc.nextInt();
      
      int newH = counts[second][0] - counts[first-1][0];
      int newG = counts[second][1] - counts[first-1][1];
      int newJ = counts[second][2] - counts[first-1][2];
      
      out.println(newH+" "+newG+" "+newJ);
    }
    out.close();
  }
}