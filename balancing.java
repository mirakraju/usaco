import java.util.*;
import java.io.*;

public class balancing{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Pair[] cows = new Pair[N];
    
    for(int i = 0; i<N; i++){
      //we can halve the y values to make our calculations smaller!
      cows[i] = new Pair(sc.nextInt(),sc.nextInt()/2);
    }
    
    //we have to sort by x's so that we can efficiently sweep from left to right 
    Arrays.sort(cows);
    
    //the greatest number of cows in one quadrant no matter what should be N cows 
    int ret = N;
    
    for(int i = 0; i< N; i++){
      ArrayList<Pair> below = new ArrayList<Pair>();
      ArrayList<Pair> above = new ArrayList<Pair>();
      for(Pair j: cows){
        if(j.y <= i)
          below.add(j);
        else
          above.add(j);
      }
    }
    
  }
  static class Pair implements Comparable<Pair>{
    public int x,y;
    public Pair(int x, int y){
      this.x = x;
      this.y = y;
    }
    public int compareTo(Pair a){
      return this.x-a.x;
    }
  }
}
  