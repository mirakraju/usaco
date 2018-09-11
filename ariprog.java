/*
ID: mirakra1
LANG: JAVA
TASK: ariprog
*/
import java.util.*;
import java.io.*;

public class ariprog{
  public static void main(String[]args)throws IOException{
    Scanner sc = new Scanner(new File("ariprog.in"));
    PrintWriter out = new PrintWriter(new File("ariprog.out"));
    
    int N = sc.nextInt();
    int M = sc.nextInt();
    
    int max = M*M*2;
    
    boolean[] isBisquare = new boolean[max+1];
    
    for(int i = 0; i<=M; i++){
      for(int j = 0; j<= M; j++){
        
        isBisquare[(i*i)+(j*j)] = true;
      }
    }
    
    
    boolean none = true;
    for(int r = 1; r<=max; r++){
      for(int a = 0; a+(r*(N-1)) <= max; a++){
        
        
        boolean isProg = true;
        for(int b = 0; b<N; b++){
          if(a+(b*r) > max || !isBisquare[a+(b*r)]){
            isProg = false;
            b = N;
          }
        }
        if(isProg){
          none = false;
          out.println(a+" "+r);
        }
      }
          
        }
    if(none)
      out.println("NONE");
    
    out.close();
  }
}