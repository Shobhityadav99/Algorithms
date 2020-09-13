package Graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class CheckifGraphisaTree {
	private int V;
	LinkedList<Integer> adj[];
	@SuppressWarnings("unchecked")
	CheckifGraphisaTree(int v){
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
			adj[i]=new LinkedList<Integer>();
	}
	void addEdge(int u,int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	boolean isCyclicUtil(int v,boolean visited[],int parent) {
		visited[v]=true;
		Iterator<Integer> it=adj[v].iterator();
		while(it.hasNext()) {
			int i=it.next();
			if(!visited[i]) {
				if(isCyclicUtil(i,visited,v))
					return true;
			}
			else if(i!=parent)
				return true;
		}
		return false;
	}
	boolean isTree() {
		boolean visited[]=new boolean[V];
		Arrays.fill(visited, false);
		if (isCyclicUtil(0, visited, -1)) 
            return false; 
        for (int u = 0; u < V; u++) 
            if (!visited[u]) 
                return false; 
  
        return true; 
	}
	public static void main(String[] args) {
		CheckifGraphisaTree g1 = new CheckifGraphisaTree(5); 
	        g1.addEdge(1, 0); 
	        g1.addEdge(0, 2); 
	        g1.addEdge(0, 3); 
	        g1.addEdge(3, 4); 
	        if (g1.isTree()) 
	            System.out.println("Graph is Tree"); 
	        else
	            System.out.println("Graph is not Tree"); 

	}

}
