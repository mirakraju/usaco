import java.util.*;
import java.io.*;

public class floodfill{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int v = 0; v < t; v++){
      int M = sc.nextInt();
      int N = sc.nextInt();
      int[][] array = new int[M][N];
      for(int m = 0; m< M; m++){
        for(int n = 0; n< N; n++){
          array[m][n] = sc.nextInt();
        }
      }
      int x = sc.nextInt();
      int y = sc.nextInt();
      final int initial = array[x][y];
      int color = sc.nextInt();
       
      LinkedList<Point> deque = new LinkedList<Point>();
      deque.add(new Point(x,y));
      
      int[] xs = {-1,0,1,0};
      int[] ys = {0,1,0,-1};
        
      while(deque.size() > 0){
        Point curr = deque.poll();
        int currx = curr.x;
        int curry = curr.y;
        if(currx>-1 && currx<M && curry > -1 && curry < N){
        int pixel = array[currx][curry];
        
        if(pixel == initial){
          array[currx][curry] = color;
          for(int i = 0; i<4; i++){
            deque.add(new Point(currx+xs[i], curry+ys[i]));
          }
        }
      }
      }
      for(int[] g: array){
        for(int p : g)
          System.out.print(p+" ");
      }
       System.out.println();  
    }
  }
  static class Point {
  public int x,y;
  public Point(int xIn, int yIn) {
   x = xIn;
   y = yIn;
  }
 }
}

