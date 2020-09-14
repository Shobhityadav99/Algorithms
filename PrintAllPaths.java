package Graphs;

import java.util.*;

public class PrintAllPaths {
	private int V;
	private LinkedList<Integer>[] adj;
	PrintAllPaths(int v){
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
			adj[i]=new LinkedList<Integer>();
	}
	public void addEdge(int u,int v) {
		adj[u].add(v);
	}
	 public void printAllPaths(int s, int d) 
	    { 
	        boolean[] isVisited = new boolean[V]; 
	        ArrayList<Integer> pathList = new ArrayList<>(); 
	        pathList.add(s); 
	        printAllPathsUtil(s, d, isVisited, pathList); 
	    } 
	 public void printAllPathsUtil(int u,int d,boolean[] visited,List<Integer> localPath) {
		 if(u==d) {
			 System.out.println(localPath);
			 return;
		 }
		 visited[u]=true;
		 for(Integer i: adj[u]) {
			 if(!visited[i]) {
				 localPath.add(i);
				 printAllPathsUtil(i,d,visited,localPath);
				 localPath.remove(i);
			 }
		 }
		 visited[u]=false;
	 }
	public static void main(String[] args) {
		PrintAllPaths g = new PrintAllPaths(4); 
	        g.addEdge(0, 1); 
	        g.addEdge(0, 2); 
	        g.addEdge(0, 3); 
	        g.addEdge(2, 0); 
	        g.addEdge(2, 1); 
	        g.addEdge(1, 3); 
	        int s = 2;  
	        int d = 3; 
	        System.out.println( "Following are all different paths from " + s + " to " + d); 
	        g.printAllPaths(s, d); 
	}

}
