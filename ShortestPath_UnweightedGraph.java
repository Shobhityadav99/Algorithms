package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ShortestPath_UnweightedGraph {
	static int V;
	static ArrayList<ArrayList<Integer>> adj;
	ShortestPath_UnweightedGraph(int v){
		V=v;
		adj=new ArrayList();
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<Integer>());
	}
	public static void addEdge(int u,int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public static void print(int s,int d) {
		int pred[]=new int[V];
		int dist[]=new int[V];
		if(BFS(s,d,pred,dist)==false) {
			System.out.println("NO SOLUTION POSSIBLE");
			return;
		}
		LinkedList<Integer> path=new LinkedList<>();
		int crawl=d;
		path.add(crawl);
		while(pred[crawl]!=-1) {
			path.add(pred[crawl]);
			crawl=pred[crawl];
		}
		 System.out.println("Shortest path length is: " + dist[d]); 
		  
	        // Print path 
	        System.out.println("Path is ::"); 
	        for (int i = path.size() - 1; i >= 0; i--) { 
	            System.out.print(path.get(i) + " "); 
	        } 
	}
	static boolean BFS(int src,int dest,int pred[],int dist[]) {
		LinkedList<Integer> queue=new LinkedList<>();
		boolean visited[]=new boolean[V];
		for(int i=0;i<V;i++) {
			visited[i]=false;
			pred[i]=-1;
			dist[i]=Integer.MAX_VALUE;
		}
		visited[src]=true;
		dist[src]=0;
		queue.add(src);
		while(!queue.isEmpty()) {
			int v=queue.poll();
			for(int i=0;i<adj.get(v).size();i++) {
				if(visited[adj.get(v).get(i)]==false) {
					visited[adj.get(v).get(i)]=true;
					queue.add(adj.get(v).get(i));
					pred[adj.get(v).get(i)]=v;
					dist[adj.get(v).get(i)]=dist[v]+1;
					if(adj.get(v).get(i)==dest)
						return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		ShortestPath_UnweightedGraph g=new ShortestPath_UnweightedGraph(8);
		 addEdge( 0, 1); 
	        addEdge( 0, 3); 
	        addEdge(1, 2); 
	        addEdge(3, 4); 
	        addEdge(3, 7); 
	        addEdge( 4, 5); 
	        addEdge(4, 6); 
	        addEdge(4, 7); 
	        addEdge( 5, 6); 
	        addEdge( 6, 7); 
	        int source = 0, dest = 7; 
	        print(source, dest); 
	}

}
