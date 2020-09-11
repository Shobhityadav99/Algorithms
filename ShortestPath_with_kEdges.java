package Graphs;

public class ShortestPath_with_kEdges {
	static final int V=4;
	static final int INF=Integer.MAX_VALUE;
	int ShortestPath(int graph[][],int u,int v,int k) {
		if(k==0 && u==v)
			return 0;
		if(graph[u][v]!=INF && k==1)
			return graph[u][v];
		if(k<=0)
			return INF;
		
		int res=INF;
		for(int i=0;i<V;i++) {
			if(graph[u][i]!=INF && u!=i && v!=i) {
				int rec_res=ShortestPath(graph,i,v,k-1);
				if(rec_res!=INF)
					res=Math.min(res, rec_res+graph[u][i]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		 int graph[][] = new int[][]{ {0, 10, 3, 2}, 
             {INF, 0, INF, 7}, 
             {INF, INF, 0, 6}, 
             {INF, INF, INF, 0} 
           }; 
           ShortestPath_with_kEdges t = new ShortestPath_with_kEdges(); 
           int u = 0, v = 3, k = 2; 
           System.out.println("Weight of the shortest path is "+ 
           t.ShortestPath(graph, u, v, k)); 
	}

}
