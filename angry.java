import java.util.*;
import java.io.*;

public class angry{
  public static void main(String[] args)throws IOException{
    Scanner sc = new Scanner(new File("angry.in"));
    PrintWriter out = new PrintWriter(new File("angry.out"));
    //Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    
    ArrayList<Integer> bales = new ArrayList<Integer>();
    
    for(int i = 0; i< N; i++){
      bales.add(sc.nextInt());
    }
    
    Collections.sort(bales);
    

    int max = bales.get(bales.size()-1);
    
    int binmax = max;
    int binmin = bales.get(0);

    while(binmax!=binmin){
      int leftBale = 0;
      int radius = (binmax+binmin)/2;
      int cows = 0;
      boolean success = false;
      while(leftBale<N){
        int curr  = leftBale+1;
        cows++;
        while(curr<N && bales.get(curr) - bales.get(leftBale) <= 2*radius)
          curr++;
        leftBale = curr;
      }
      
      if(cows<=K)
        success = true;
      
      if(success){
        binmax = radius;
      }
      if(!success){
        binmin = radius+1;
      }
      //System.out.println("MAX: "+binmax+" MIN: "+binmin);
      }
    out.println(binmax);
    out.close();
    
    }
  }
