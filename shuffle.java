import java.util.*;
import java.io.*;

public class shuffle{
  public static void main(String[] args)throws IOException{
    Scanner sc = new Scanner(new File("shuffle.in"));
    PrintWriter out = new PrintWriter(new File("shuffle.out"));
    
    int N = sc.nextInt();
    
    ArrayList<Integer> cows = new ArrayList<Integer>();
    boolean[] full = new boolean[N];
    
    for(int i = 0; i< N; i++){
      cows.add(sc.nextInt()-1);
    }
    
    int fullNum = 0;
    
    for(int i = 0; i<N; i++){
      ArrayList<Integer> possLoop = new ArrayList<Integer>();
      int curr = i;
      boolean already = false;
      boolean found = false;
      while(!already && !found && curr<cows.size()){
        if(full[curr])
          already = true;
        else{
        possLoop.add(curr);
        curr = cows.get(curr);
        if(possLoop.contains(curr))
          found = true;
        }
      }

      if(!already && found){
        for(int j = possLoop.size()-1; j>=0; j--){
          full[possLoop.get(j)] = true;
          if((possLoop.get(j)) == curr)
            break;
        }
      }
      
    }
    
    for(boolean i:full){
      if(i)
        fullNum++;
    }
    
    out.println(fullNum);
    out.close();
  }
}