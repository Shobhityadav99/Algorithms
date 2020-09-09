package Graphs;
import java.util.*; 
import java.lang.*; 
import java.io.*; 
public class bellmanFordAlgo {
	class Edge{
		int src,dest,weight;
		Edge(){
			src=dest=weight=0;
		}
	}
	int V,E;
	Edge edge[];
	bellmanFordAlgo(int v,int e){
		V=v;
		E=e;
		edge=new Edge[E];
		for(int i=0;i<E;i++)
			edge[i]=new Edge();
	}
	void BellManFord(int src) {
		int dist[]=new int[V];
		for(int i=0;i<V;i++)
			dist[i]=Integer.MAX_VALUE;
		dist[src]=0;
		
		for(int i=1;i<V;i++) {
			for(int j=0;j<E;j++) {
				int u=edge[j].src;
				int v=edge[j].dest;
				int weight=edge[j].weight;
				if(dist[u] != Integer.MAX_VALUE && dist[u]+weight<dist[v]) {
					 dist[v] = dist[u] + weight; 
				}	
			}
		}
		for(int i=1;i<V;i++) {
			for(int j=0;j<E;j++) {
				int u=edge[j].src;
				int v=edge[j].dest;
				int weight=edge[j].weight;
				if(dist[u] != Integer.MAX_VALUE && dist[u]+weight<dist[v]) {
					System.out.println("Negative Cycle");
					return;
				}	
			}
		}
		printdistance(dist,V);
	}
	void printdistance(int dist[],int V){
		for(int i=0;i<V;i++) {
			System.out.println(i+"    "+dist[i]);
		}
	}
	public static void main(String[] args) {
		int V = 5; // Number of vertices in graph 
        int E = 8; // Number of edges in graph 
  
        bellmanFordAlgo graph = new bellmanFordAlgo(V, E); 
  
        // add edge 0-1 (or A-B in above figure) 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = -1; 
  
        // add edge 0-2 (or A-C in above figure) 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 4; 
  
        // add edge 1-2 (or B-C in above figure) 
        graph.edge[2].src = 1; 
        graph.edge[2].dest = 2; 
        graph.edge[2].weight = 3; 
  
        // add edge 1-3 (or B-D in above figure) 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 2; 
  
        // add edge 1-4 (or A-E in above figure) 
        graph.edge[4].src = 1; 
        graph.edge[4].dest = 4; 
        graph.edge[4].weight = 2; 
  
        // add edge 3-2 (or D-C in above figure) 
        graph.edge[5].src = 3; 
        graph.edge[5].dest = 2; 
        graph.edge[5].weight = 5; 
  
        // add edge 3-1 (or D-B in above figure) 
        graph.edge[6].src = 3; 
        graph.edge[6].dest = 1; 
        graph.edge[6].weight = 1; 
  
        // add edge 4-3 (or E-D in above figure) 
        graph.edge[7].src = 4; 
        graph.edge[7].dest = 3; 
        graph.edge[7].weight = -3; 
  
        graph.BellManFord(0); 
    } 
	}
