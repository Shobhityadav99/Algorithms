package Graphs;
import java.util.*;
public class ConnectedComponentsinUndirectedGraph {
	int V;
	LinkedList<Integer> adj[];
	ConnectedComponentsinUndirectedGraph(int v){
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
			adj[i]=new LinkedList<Integer>();
	}
	void addEdge(int u,int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	void DFSUtil(int v,boolean visited[]) {
		visited[v]=true;
		System.out.print(v+" ");
		for(int x: adj[v])
			if(!visited[x])
				DFSUtil(x,visited);
	}
	void ConnectedComponents() {
		boolean visited[]=new boolean[V];
		for(int v=0;v<V;v++) {
			if(!visited[v]) {
				DFSUtil(v,visited);
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		ConnectedComponentsinUndirectedGraph g = new ConnectedComponentsinUndirectedGraph(5); // 5 vertices numbered from 0 to 4  
         
	        g.addEdge(1, 0);  
	        g.addEdge(2, 3);  
	        g.addEdge(3, 4); 
	        System.out.println("Following are connected components"); 
	        g.ConnectedComponents(); 

	}

}
