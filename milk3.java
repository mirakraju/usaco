/*
ID: mirakra1
LANG: JAVA
TASK: milk3
*/

import java.util.*;
import java.io.*;

public class milk3{
  public static int a;
  public static int b;
  public static int c;
  
  public static boolean[][] visited = new boolean[21][21];
  public static boolean[] accept = new boolean[21];
  
  public static void main(String[] args) throws IOException{
    PrintWriter out = new PrintWriter(new File("milk3.out"));
    Scanner sc = new Scanner(new File("milk3.in"));
    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    
   dfs(0,0,c);
     boolean first = true;
    for(int i = 0; i<accept.length; i++)
    {

     if(accept[i]){
       if(first){
         out.print(i);
         first = false;
       }
       else
         out.print(" "+i);
         
     }   
    }
    out.println();
   out.close(); 
}
  
  public static void dfs(int x, int y, int z){
    if(visited[x][y])
      return;
    visited[x][y] = true;
    if(x == 0)
      accept[z] = true;
/////different cases 
    
    //pour a into b
    if(x > 0 && y < b){
      dfs(Math.max(0,x+y-b), Math.min(b,x+y), z);
    }
    
    //pour a into c
    if(x > 0 && z < c){
      dfs(Math.max(0,x+z-c),y, Math.min(c,x+z));
    }
    
    //pour b into a
    if(y>0 && x < a){
      dfs(Math.min(a,y+x),Math.max(0,y+x-a),z);
    }
    
    //pour b into c
    if(y>0 && z < c){
      dfs(x,Math.max(0,y+z-c), Math.min(c,y+z));
    }
    
    //pour c into a
    if(z > 0 && x < a){
      dfs(Math.min(a,x+z),y,Math.max(0,x+z-a));
    }
    
    //pour c into b
    if(z > 0 && y < b){
      dfs(x,Math.min(b,y+z),Math.max(0,y+z-b));
    }

  }
}