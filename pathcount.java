import java.util.*;
import java.lang.*;
import java.io.*;

class pathcount {
    
    public static HashMap<Integer, ArrayList<Integer>> roads = new HashMap<Integer, ArrayList<Integer>>();
    public static ArrayList<Integer> visited = new ArrayList<Integer>();
 public static void main (String[] args) {
  Scanner sc = new Scanner(System.in);
  int T = sc.nextInt();
  int V = sc.nextInt();
  int E = sc.nextInt();
  for(int i = 0; i<T; i++){
      
      for(int j = 0; j<(E); j++){
          int a = sc.nextInt();
          int b = sc.nextInt();
          
          if(!roads.containsKey(a)){
              ArrayList<Integer> curr = new ArrayList<Integer>();
              curr.add(b);
              roads.put(a,curr);
          }
          else{
              ArrayList<Integer> curr = roads.get(a);
              curr.add(b);
              roads.replace(a,curr);
          }
      }
      System.out.println(roads);
      int first = sc.nextInt();
      int last = sc.nextInt();
      
      for(int k = 0; k<V; k++)
        visited.add(0);
      
      System.out.println(dfs(first,last, V));
      
      
      
  }
 }
 
 public static int dfs(int start, int last, int V){
   if(visited.get(start) != 0)
     return 0;
   if(start == last){
     for(int j = 0; j<V; j++)
       visited.set(j,0);
     return 1;
   }

     visited.set(start,1);
     ArrayList<Integer> curr = roads.get(start);
   for(int j:curr){

       return(dfs(j,last, V));
   }
   
     
    return 0; 
 }
 
}