package Graphs;

import java.util.*;

public class StronglyConnectedKosaraju {
	private int V;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	StronglyConnectedKosaraju(int v){
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
			adj[i]=new LinkedList<Integer>();
	}
	void addEdge(int u,int v) {
		adj[u].add(v);
	}
	void DFSUtil(int v,boolean visited[]) {
		visited[v]=true;
	    	Iterator<Integer> it=adj[v].listIterator();
	    	while(it.hasNext()) {
	    		int i=it.next();
	    		if(!visited[i])
	    			DFSUtil(i,visited);
	    	}
	    }
	StronglyConnectedKosaraju getTranspose() {
		StronglyConnectedKosaraju g=new StronglyConnectedKosaraju(V);
		for(int v=0;v<V;v++) {
			Iterator<Integer> it=adj[v].listIterator();
			while(it.hasNext())
				adj[it.next()].add(v);
		}
		return g;
	}
	boolean isStronglyConnected() {
		boolean visited[]=new boolean[V];
		Arrays.fill(visited, false);
		DFSUtil(0,visited);
		for(int i=0;i<V;i++)
			if(!visited[i])
				return false;
		StronglyConnectedKosaraju gr=getTranspose();
		Arrays.fill(visited, false);
		DFSUtil(0,visited);
		for(int i=0;i<V;i++)
			if(!visited[i])
				return false;
		return true;
	}
	public static void main(String[] args) {
		StronglyConnectedKosaraju g1 = new StronglyConnectedKosaraju(5); 
	        g1.addEdge(0, 1); 
	        g1.addEdge(1, 2); 
	        g1.addEdge(2, 3); 
	        g1.addEdge(3, 0); 
	        g1.addEdge(2, 4); 
	        g1.addEdge(4, 2); 
	        if (g1.isStronglyConnected()) 
	            System.out.println("Yes"); 
	        else
	            System.out.println("No"); 
	  
	        StronglyConnectedKosaraju g2 = new StronglyConnectedKosaraju(4); 
	        g2.addEdge(0, 1); 
	        g2.addEdge(1, 2); 
	        g2.addEdge(2, 3); 
	        if (g2.isStronglyConnected()) 
	            System.out.println("Yes"); 
	        else
	            System.out.println("No");
	}

}
