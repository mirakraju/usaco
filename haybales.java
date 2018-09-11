import java.util.*;
import java.io.*;

public class haybales{
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(new File("haybales.in"));
    PrintWriter out = new PrintWriter(new File("haybales.out"));
    int N = sc.nextInt();
    int Q = sc.nextInt();
    
    int[] bales = new int[N];
    
    for(int i = 0; i<N; i++){
      bales[i] = sc.nextInt();
    }
    
    Arrays.sort(bales);
    
    for(int i = 0; i< Q; i++){
      int a = sc.nextInt()-1;
      int b = sc.nextInt();
      out.println(count(bales,b) - count(bales,a));
    }
    out.close();
  }
  public static int count(int[] list, int limit){
    if(list[0] > limit)
      return 0;
    int min = 0;
    int max = list.length-1;
    while(min!=max){
     int mid = (max+min+1)/2;
     if(list[mid]<=limit)
       min = mid;
     else
       max = mid-1;
    }
    return min+1;
  }
}