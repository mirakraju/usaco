//ask joanne
import java.util.*;
import java.io.*;

public class lightson{
  public static boolean[][] visited;
  public static boolean[][] lightOn;
  public static HashMap<Pair,ArrayList<Pair>> connect = new HashMap<Pair,ArrayList<Pair>>();
  public static int N;
  public static int M;
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
   N = sc.nextInt();
   M = sc.nextInt();
    Pair add = new Pair(1,2);
    Pair but = new Pair(1,2);
    System.out.println(add==but);
    visited = new boolean[N][N];
    lightOn = new boolean[N][N];
    
    for(int i = 0; i<M; i++){
      int a = sc.nextInt()-1;
      int b = sc.nextInt()-1;
      int x = sc.nextInt()-1;
      int y = sc.nextInt()-1;
      
      Pair key = new Pair(a,b);
      Pair value = new Pair(x,y);
      
      if(!connect.containsKey(key)){
        ArrayList<Pair> curr = new ArrayList<Pair>();
        curr.add(value);
        connect.put(key,curr);
      }
      else{
        ArrayList<Pair> curr = connect.get(key);
        curr.add(value);
        connect.replace(key,curr);
      }
      }
    
    System.out.println(connect);
     lightOn[0][0] = true;
     
     int fin = dfs(0,0,1);
     System.out.println(fin);
  }
 
  public static int dfs(int a, int b, int c){
    int numLights = c;
    if(visited[a][b]){
      System.out.println(1);
      return c;
    }
    visited[a][b] = true;
    if(!lightOn[a][b]){
      System.out.println(2);
      return c;
    }
    if(a > N-1 || a< 0 || b> N-1 || b<0){
      System.out.println(3);
      return c;
    }
    Pair curr = new Pair(a,b);
    System.out.println(curr);
    System.out.println(connect);
    if(!connect.containsKey(curr)){
      System.out.println(4);
      return c;
    }
    ArrayList<Pair> currConnects = new ArrayList<Pair>();
    
    for(Pair t: currConnects){
      int x = t.a;
      int y = t.b;
      lightOn[x][y] = true;
      //System.out.print(t+" ");
      numLights++;
    }
    
    int[] x = {0,1,0,-1};
    int[] y = {1,0,-1,0};
    
    
    /*
    for(int i = 0; i<4; i++){
      dfs(a+x[i],b+y[i],numLights);
    }*/
    
      return 0;
  }
  
  
}
class Pair implements Comparable<Pair> {
  public int a;
  public int b;
  public Pair(int x, int y){
    a = x;
    b = y;
  }
  
  public boolean equals(Object p){
    if(p==this)
      return true;
    if(!(p instanceof Pair))
      return false;
    
    Pair user = (Pair) p;
    return(user.a == a && user.b == b);

  }
  
   public int hashCode() {
    return Objects.hash(a,b);
  }
  
  public int compareTo(Pair p){
    if(this.a > p.a)
      return 1;
    else if(this.a < p.a)
      return -1;
    else{
      if(this.b > p.b)
        return 1;
      else if(this.b < p.b)
        return -1;
      else
        return 0;
    }
  }
  
  
  public String toString(){
    return(a+" "+b);
  }
    
}