import java.util.*;
import java.io.*;
public class countcross {
    static HashMap<Pair,ArrayList<Pair>> roads = new HashMap<Pair,ArrayList<Pair>>();
    static int[][] grid;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("countcross.in"));
        PrintWriter out = new PrintWriter(new File("countcross.out"));
        int N = sc.nextInt();
        int K = sc.nextInt();
        int R = sc.nextInt();
        
        ArrayList<Pair> cows = new ArrayList<Pair>();
       
        grid = new int[N][N];
        
        for(int i = 0; i< R; i++) {
            int ax = sc.nextInt()-1;
            int ay = sc.nextInt()-1;
            int bx = sc.nextInt()-1;
            int by = sc.nextInt()-1;
            
            Pair a = new Pair(ax,ay);
            Pair b = new Pair(bx,by);
            
        //put all of the connections into a HashMap
            if(roads.containsKey(a)) {
                ArrayList<Pair> curr = roads.get(a);
                curr.add(b);
                roads.put(a, curr);
            }
            else {
                ArrayList<Pair> newList = new ArrayList<Pair>();
                newList.add(b);
                roads.put(a,newList);
            }
            
            if(roads.containsKey(b)) {
                ArrayList<Pair> curr = roads.get(b);
                curr.add(a);
                roads.put(b, curr);
            }
            else {
                ArrayList<Pair> newList = new ArrayList<Pair>();
                newList.add(a);
                roads.put(b,newList);
            }
        }

        // this part has 0 indexing for pairs
        for(int i = 0; i<K; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            Pair a = new Pair(x,y);
            cows.add(a);
        }
        int groupNum = 1;
        for(int i = 0; i< N; i++) {
            for(int j = 0; j<N; j++) {
                if(grid[i][j]==0) {
                    fillAreas(i,j,groupNum);
                    groupNum ++;
                }
            }
        }
        
        int[] counts = new int[groupNum];
        
        for(int i = 0; i<cows.size(); i++) {
            int x = cows.get(i).x;
            int y = cows.get(i).y;
            
            counts[grid[x][y]] += 1;
        }
       
        
        int pairProduct = 0;
        int currSum = counts[0];
        
        for(int i = 0; i<groupNum-1; i++) {
            pairProduct  += currSum * counts[i+1];
            currSum  = currSum + counts[i+1];
        }
        
       out.println(pairProduct);
            out.close();
        }
        //floodfill
        
        //run through all cows, increment group assignments
        
        //count pairs


    static class Pair{
        int x;
        int y;
        public Pair(int x ,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
        Pair b = (Pair) o;
        return b.hashCode() == this.hashCode();
        }
        
        @Override
        public int hashCode() {
            int first = 100*x;
            int second = y;
            return first+second;
        }
    }
        
    static void fillAreas(int x, int y, int group) {
        if(x<0 || y<0 || y>=grid.length || x >= grid.length)
            return;
        if(grid[x][y] != 0)
            return;
        grid[x][y] = group;
        
        int[] xs = {0,1,0,-1};
        int[] ys = {1,0,-1,0};
        
        for(int i = 0; i<4; i++) {
            int newx = x+xs[i];
            int newy = y+ys[i];
            
            ArrayList<Pair> curr = roads.get(new Pair(x,y));
            
            if(curr == null)
                fillAreas(newx,newy,group); 
            else if(!curr.contains(new Pair(newx,newy))){
                fillAreas(newx, newy, group);
            }       
        }
    }


}
