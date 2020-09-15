package Graphs;

import java.util.*;

public class GraphColoring {
	int V;
	LinkedList<Integer>[] adj;
	GraphColoring(int v){
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
			adj[i]=new LinkedList<Integer>();
	}
	void addEdge(int u,int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	void greedyColoring() {
		int result[]=new int[V];
		Arrays.fill(result, -1);
		result[0]=0;
		boolean available[]=new boolean[V];
		Arrays.fill(available, true);
		for(int u=1;u<V;u++) {
			Iterator<Integer> it=adj[u].listIterator();
			while(it.hasNext()) {
				int i=it.next();
				if(result[i]!=-1)
					available[result[i]]=false;
			}
			int cr;
			for(cr=0;cr<V;cr++)
				if(available[cr])
					break;
			result[u]=cr;
			Arrays.fill(available, true);
		}
		 for (int u = 0; u < V; u++) 
	            System.out.println("Vertex " + u + " --->  Color "
	                                + result[u]); 
	}
	public static void main(String[] args) {
		GraphColoring g1 = new GraphColoring(5); 
	        g1.addEdge(0, 1); 
	        g1.addEdge(0, 2); 
	        g1.addEdge(1, 2); 
	        g1.addEdge(1, 3); 
	        g1.addEdge(2, 3); 
	        g1.addEdge(3, 4); 
	        System.out.println("Coloring of graph 1"); 
	        g1.greedyColoring(); 
	  
	        System.out.println(); 
	        GraphColoring g2 = new GraphColoring(5); 
	        g2.addEdge(0, 1); 
	        g2.addEdge(0, 2); 
	        g2.addEdge(1, 2); 
	        g2.addEdge(1, 4); 
	        g2.addEdge(2, 4); 
	        g2.addEdge(4, 3); 
	        System.out.println("Coloring of graph 2 "); 
	        g2.greedyColoring(); 

	}

}
