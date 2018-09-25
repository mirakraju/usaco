import java.util.*;
import java.io.*;

public class meeting {
	static HashMap<Integer,ArrayList<Integer>> paths = new HashMap<Integer, ArrayList<Integer>>();
	static HashMap<Integer,ArrayList<Integer>> speeds = new HashMap<Integer, ArrayList<Integer>>();
	static ArrayList<Integer> bspeeds = new ArrayList<Integer>();
	static ArrayList<Integer> espeeds = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("meeting.in"));
		PrintWriter out = new PrintWriter(new File("meeting.out"));
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for(int i = 0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			int min = Math.min(a, b);
			int max = Math.max(a, b);
			
			if(paths.containsKey(min)) {
				ArrayList<Integer> curr = paths.get(min);
				curr.add(max);
				paths.put(min, curr);
			}
			else {
				ArrayList<Integer> nList = new ArrayList<Integer>();
				nList.add(max);
				paths.put(min, nList);
			}
			
			//generate a hashcode ish thing for each pair
			//so we've got a max of 100, so we'll do 100*x+y
			int accessKey = min*100+max;
			ArrayList<Integer> sp = new ArrayList<Integer>();
			sp.add(c);
			sp.add(d);
			speeds.put(accessKey, sp);
		}
		//find all paths from 1 to meeting place, and their values for Bessie and Elsie. Store those values in 
		//arraylist
		
		dfs(1,0,0,N);
		

		bspeeds.retainAll(espeeds);
		
		if(bspeeds.size()==0)
			out.println("IMPOSSIBLE");
		
		else {
		int min = Collections.min(bspeeds);
		out.println(min);
		}
out.close();
	}
	
	static void dfs(int curr, int bcount, int ecount, int N) {
		if(curr>N || curr<1)
			return;
		if(curr == N) {
			bspeeds.add(bcount);
			espeeds.add(ecount);
		}
		
		ArrayList<Integer> poss = paths.get(curr);
		
		if(poss==null)
			return;
		
		for(int i:poss) {
			int ind = curr*100+i;
			int b = speeds.get(ind).get(0);
			int e = speeds.get(ind).get(1);
			dfs(i,bcount+b,ecount+e,N);
		}
	
	}

}
