//ask joanne
import java.util.*;
import java.io.*;
//run through 0-6, get earliest instance and last instance, print largest
public class div7{
  public static void main(String[] args)throws IOException{
    Scanner sc = new Scanner(new File("div7.in"));
    PrintWriter out = new PrintWriter(new File("div7.out"));
    //Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    
    int[] psums = new int[N+1];
    
    int sum = 0;
    for(int i = 1; i<N+1; i++){
      int curr=  sc.nextInt();
      sum = sum+curr;
      sum = sum % 7;
      psums[i] = sum;
    }
    
    int interval = N;
    boolean found = false;
    
    while(!found){
      int first = 0;
      
      while(!found && first+interval<=N){
        int a = psums[first];
        int b = psums[first+interval];
        
        if((b-a)%7 == 0){
          out.println(interval);
          found = true;
        }
        else{
          first++;
        }
    }
interval--;
if(interval == 0){
  out.println(0);
  break;
}
    }
    out.close();
  }
}