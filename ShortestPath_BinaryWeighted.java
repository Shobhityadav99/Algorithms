package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class ShortestPath_BinaryWeighted {
	public static class Node{
		int to,weight;
		Node(int to,int wt){
			this.to=to;
			this.weight=wt;
		}
	}
	static int V=9;
	private ArrayList<Node>[] edges=new ArrayList[V];
	ShortestPath_BinaryWeighted() {
		for(int i=0;i<V;i++)
			edges[i]=new ArrayList<Node>();
	}
	 void addEdge(int u,int v,int weight) {
		 edges[u].add(edges[u].size(),new Node(v,weight));
		 edges[v].add(edges[v].size(),new Node(u,weight));
	}
	 public void ZeroOneBFS(int src) {
		 int dist[]=new int[V];
		 Arrays.fill(dist, Integer.MAX_VALUE);
		 Deque<Integer> queue = new ArrayDeque<Integer>(); 
	        dist[src] = 0; 
	        queue.addLast(src); 
	          
	        while (!queue.isEmpty()) { 
	            int v = queue.removeFirst(); 
	            for (int i = 0; i < edges[v].size(); i++) { 
	  
	                // checking for optimal distance 
	                if (dist[edges[v].get(i).to] >  
	                        dist[v] + edges[v].get(i).weight) { 
	  
	                    // update the distance 
	                    dist[edges[v].get(i).to] = 
	                          dist[v] + edges[v].get(i).weight; 
	  
	                    // put 0 weight edges to front and 1 
	                    // weight edges to back so that vertices 
	                    // are processed in increasing order of weight 
	                    if (edges[v].get(i).weight == 0) { 
	                        queue.addFirst(edges[v].get(i).to); 
	                    } else { 
	                        queue.addLast(edges[v].get(i).to); 
	                    } 
	                } 
	            } 
	        } 
	          
	        for (int i = 0; i < dist.length; i++) { 
	            System.out.print(dist[i] + " "); 
	        } 
	    } 
	      
	    public static void main(String[] args) { 
	    	ShortestPath_BinaryWeighted graph = new ShortestPath_BinaryWeighted(); 
	        graph.addEdge(0, 1, 0); 
	        graph.addEdge(0, 7, 1); 
	        graph.addEdge(1, 7, 1); 
	        graph.addEdge(1, 2, 1); 
	        graph.addEdge(2, 3, 0); 
	        graph.addEdge(2, 5, 0); 
	        graph.addEdge(2, 8, 1); 
	        graph.addEdge(3, 4, 1); 
	        graph.addEdge(3, 5, 1); 
	        graph.addEdge(4, 5, 1); 
	        graph.addEdge(5, 6, 1); 
	        graph.addEdge(6, 7, 1); 
	        graph.addEdge(7, 8, 1); 
	        int src = 0;//source node 
	        graph.ZeroOneBFS(src); 
	        return; 
	    } 
	} 