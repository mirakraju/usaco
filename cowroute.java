import java.util.*;
import java.io.*;

public class cowroute {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("cowroute.in"));
    	//Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new File("cowroute.out"));
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> routes = new ArrayList<ArrayList<Integer>>();
        
        //initialize first element of arraylist as cost. then fill rest.
        
        for(int i = 0; i< n; i++) {
            int cost = sc.nextInt();
            int len = sc.nextInt();
            
            ArrayList<Integer> curr = new ArrayList<Integer>();
            
            curr.add(cost);
            
            for(int j = 0; j<len; j++)
                curr.add(sc.nextInt());
            routes.add(curr);
        }
        
        int minCost = Integer.MAX_VALUE;
        

        for(ArrayList<Integer> s: routes) {
            int firsta = s.lastIndexOf(a);
            //System.out.println(firsta);
            int firstb = s.lastIndexOf(b);
            //System.out.println(firstb);
            if(firsta>0&&firstb>0&&firsta<firstb) {
                if(s.get(0)<minCost)
                    minCost = s.get(0);
            }   
        }
        
        if(minCost == Integer.MAX_VALUE) {
        	out.println(-1);
        }
       else
       		out.println(minCost);
        out.close();
    }
}
