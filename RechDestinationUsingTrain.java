package Graphs;

public class RechDestinationUsingTrain {
	static int INF=Integer.MAX_VALUE;
	static int N=4;
	static int minCost(int cost[][],int s,int d) {
		if(s==d || s+1==d) {
			return cost[s][d];
		}
		int min=cost[s][d];
		for(int i=s+1;i<d;i++) {
			int c=minCost(cost,s,i)+minCost(cost,i,d);
			if(c<min)
				min=c;
		}
		return min;
	}
	public static void main(String[] args) {
		 int cost[][] = { {0, 15, 80, 90}, 
                 {INF, 0, 40, 50}, 
                 {INF, INF, 0, 70}, 
                 {INF, INF, INF, 0} 
               }; 
   System.out.println("The Minimum cost to reach station "+ N+  " is "+minCost(cost,0,N-1));

	}

}
