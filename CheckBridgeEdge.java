package Graphs;

import java.util.*;

public class CheckBridgeEdge {
	private int V;
	private LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	CheckBridgeEdge(int v){
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
	    	Iterator<Integer> it=adj[v].listIterator();
	    	while(it.hasNext()) {
	    		int i=it.next();
	    		if(!visited[i])
	    			DFSUtil(i,visited);
	    	}
	    }
	boolean isConnected() {
		boolean visited[]=new boolean[V];
		Arrays.fill(visited, false);
		
		DFSUtil(0,visited);
		for(int i=0;i<V;i++)
			if(!visited[i])
				return false;
		return true;
	}
	boolean isBridge(int u,int v) {
		adj[v].remove(u);
		boolean res=isConnected();
		addEdge(u,v);
		return (res==false);
	}
	public static void main(String[] args) {
		CheckBridgeEdge g=new CheckBridgeEdge(4);
		    g.addEdge(0, 1); 
		    g.addEdge(1, 2); 
		    g.addEdge(2, 3); 
		    System.out.println(g.isBridge(1, 2));
	}
}