package Graphs;

import java.util.*;

public class fordFulkersonMaxFlow {
	boolean bfs(int graph[][],int V,int s,int t,int parent[]) {
		boolean visited[]=new boolean[V];
		Arrays.fill(visited, false);
		
		LinkedList<Integer> q=new LinkedList<>();
		q.add(s);
		visited[s]=true;
		parent[s]=-1;
		while(!q.isEmpty()) {
			int u=q.poll();
			for(int v=0;v<V;v++) {
				if(visited[v]==false && graph[u][v]>0) {
					q.add(v);
					visited[v]=true;
					parent[v]=u;
				}
				
			}
		}
		return (visited[t]==true);
	}
	 int fordFulkerson(int graph[][],int V,int s,int t) {
		int rgraph[][]=new int[V][V];
		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				rgraph[i][j]=graph[i][j];
		
		int parent[]=new int[V];
		int max_flow=0;
		
		while(bfs(rgraph,V,s,t,parent)) {
			int path_flow=Integer.MAX_VALUE;
			
			for(int v=t;v!=s;v=parent[v]) {
				int u=parent[v];
				path_flow=Math.min(path_flow, rgraph[u][v]);
			}
			
			for(int v=t;v!=s;v=parent[v]) {
				int u=parent[v];
				rgraph[u][v]-=path_flow;
				rgraph[v][u]+=path_flow;
			}
			max_flow+=path_flow;
		}
		return max_flow;
	}
	public static void main(String[] args) {
		int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0}, 
            {0, 0, 10, 12, 0, 0}, 
            {0, 4, 0, 0, 14, 0}, 
            {0, 0, 9, 0, 0, 20}, 
            {0, 0, 0, 7, 0, 4}, 
            {0, 0, 0, 0, 0, 0} 
          }; 
          fordFulkersonMaxFlow g=new fordFulkersonMaxFlow();
System.out.println("The maximum possible flow is " + 
		g.fordFulkerson(graph,6, 0, 5)); 
	}

}