import java.util.*;
import java.io.*;

public class citystate{
  public static void main(String[] args)throws IOException{
    Scanner sc = new Scanner(new File("citystate.in"));
    PrintWriter out = new PrintWriter(new File("citystate.out"));
    int N = sc.nextInt();
    HashMap<String,Long> count = new HashMap<String,Long>();
    for(int i = 0; i<N; i++){
      String city = sc.next();
      String state = sc.next();
      if(!city.substring(0,2).equals(state)){
        String now = city.substring(0,2) + state;
        if(!count.containsKey(now)){
          count.put(now,0L);
        }
        count.put(now,count.get(now)+1);
      }
    }
    int sum = 0;
    
    for(String s:count.keySet()){
      String reverse = s.substring(2)+s.substring(0,2);
      if(count.containsKey(reverse)){
        sum += count.get(reverse)*count.get(s);
      }
    }
    out.println(sum/2);
    out.close();
  }
}