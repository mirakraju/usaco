import java.util.*;
import java.io.*;

public class pairup {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("pairup.in"));
        PrintWriter out = new PrintWriter(new File("pairup.out"));
        int N = sc.nextInt();
        ArrayList<Pair> times = new ArrayList<Pair>();
        for(int i = 0; i<N; i++) {
            int cows = sc.nextInt();
            int time = sc.nextInt();
            Pair n = new Pair(cows,time);
            times.add(n);
        }

        Collections.sort(times);
        
        int tiempos = 0;
        
        
        int left = 0;
        int right = times.size()-1;
        while(left<right){
            Pair leftCow = times.get(left);
            Pair rightCow = times.get(right);
            
            int leftRemaining = leftCow.x;
            int rightRemaining = rightCow.x;

            tiempos = Math.max(rightCow.y+leftCow.y, tiempos);
            
            if(leftRemaining < rightRemaining){
                times.set(right, new Pair(rightCow.x-leftRemaining,rightCow.y));
                left += 1;
            }
            else if(leftRemaining > rightRemaining){
                times.set(left, new Pair(leftCow.x-rightRemaining, leftCow.y));
                right -= 1;
            }
            else{
                right-=1;
                left+=1;
            }
            
            System.out.println("Left: "+left);
            System.out.println("Right: " +right);
        }
        if(left == right){
            tiempos = Math.max(times.get(right).y*2,tiempos);
        }
        
        out.println(tiempos);
        out.close();
    }
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return ("("+this.x+","+this.y+")");
        }
        @Override
        public int compareTo(Pair o) {
            return this.y-o.y;
        }
    }
}