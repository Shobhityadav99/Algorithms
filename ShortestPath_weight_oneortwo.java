package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath_weight_oneortwo {
	static class Graph{
		int V;
		LinkedList<Integer>[] adj;
		static int level;
		Graph(int v){
			this.V=v;
			this.adj=new LinkedList[2*V];
			for(int i=0;i<2*V;i++)
				this.adj[i]=new LinkedList<Integer>();
		}
		public void addEdge(int v,int u,int weight) {
			if(weight==2) {
				adj[v].add(v+this.V);
				adj[v+this.V].add(u);
			}
			else
			adj[v].add(u);
		}
		 public int printShortestPath(int[] parent, int s, int d) 
	        { 
	            level = 0; 
	            if (parent[s] == -1) 
	            { 
	                System.out.printf("Shortest Path between"+  
	                                "%d and %d is %s ", s, d, s); 
	                return level; 
	            } 
	  
	            printShortestPath(parent, parent[s], d); 
	  
	            level++; 
	            if (s < this.V) 
	                System.out.printf("%d ", s); 
	  
	            return level; 
	        } 
		 public int findShortestPath(int src, int dest) 
	        { 
	            boolean[] visited = new boolean[2 * this.V]; 
	            int[] parent = new int[2 * this.V]; 
	            for (int i = 0; i < 2 * this.V; i++)  
	            { 
	                visited[i] = false; 
	                parent[i] = -1; 
	            } 
	            Queue<Integer> queue = new LinkedList<>(); 
	            visited[src] = true; 
	            queue.add(src); 
	  
	            while (!queue.isEmpty())  
	            { 
	                int s = queue.peek(); 
	  
	                if (s == dest) 
	                    return printShortestPath(parent, s, dest); 
	                queue.poll(); 
	                for (int i : this.adj[s])  
	                { 
	                    if (!visited[i])  
	                    { 
	                        visited[i] = true; 
	                        queue.add(i); 
	                        parent[i] = s; 
	                    } 
	                } 
	            } 
	            return 0; 
	        } 
	    } 
	    public static void main(String[] args) 
	    { 
	        int V = 4; 
	        Graph g = new Graph(V); 
	        g.addEdge(0, 1, 2); 
	        g.addEdge(0, 2, 2); 
	        g.addEdge(1, 2, 1); 
	        g.addEdge(1, 3, 1); 
	        g.addEdge(2, 0, 1); 
	        g.addEdge(2, 3, 2); 
	        g.addEdge(3, 3, 2); 
	  
	        int src = 0, dest = 3; 
	        System.out.printf("\nShortest Distance between" +  
	                            " %d and %d is %d\n", src,  
	                            dest, g.findShortestPath(src, dest)); 
	    } 
	} 