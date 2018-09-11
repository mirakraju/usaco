import java.util.*;
import java.io.*;

public class cowdance{
  public static void main(String[] args)throws IOException{
    Scanner sc = new Scanner(new File("cowdance.in"));
    PrintWriter out = new PrintWriter(new File("cowdance.out"));
    int N = sc.nextInt();
    int T = sc.nextInt();
    
    int[] cows = new int[N];
    
    for(int i = 0;i<N; i++){
      cows[i] = sc.nextInt();
    }
    //the largest stage size would fit all the cows at once
    int max = N;
    //the least stage size is 1
    int min = 1;
    
    //binary search for the smallest working stage size
    
    while(max!=min){
      int med = (max+min)/2;
      //if the test is successful, set it as the maximum successful size
      if(test(cows,T,med))
        max = med;
      //if not, set the minimum successful size as 1+med
      else
        min = med+1;
    }
    
    out.println(min);
    out.close();
  }
  public static boolean test(int[] cows, int T, int K){
    int lastCow = 0;
    PriorityQueue<Integer> times = new PriorityQueue<Integer>();
    for(int i:cows){
      if(times.size() == K)
        lastCow = times.poll();
      if(i+lastCow > T)
        return false;
      times.add(lastCow+i);
    }
    return true;
    }
  }
    