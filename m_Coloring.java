package Graphs;

import java.util.Arrays;

public class m_Coloring {
	final int V=4;
	int color[];
	boolean isSafe(int v,int color[],int graph[][],int c) {
		for(int i=0;i<V;i++) {
			if(graph[v][i]==1 && c==color[i])
				return false;
		}
		return true;
	}
	boolean graphColorUtil(int graph[][],int m,int color[],int v) {
		if(v==V)
			return true;
		for(int c=1;c<=m;c++) {
			if(isSafe(v,color,graph,c)) {
				color[v]=c;
				if(graphColorUtil(graph,m,color,v+1))
					return true;
				color[v]=0;
			}
		}
		return false;
	}
	boolean graphcoloring(int graph[][],int m) {
		color=new int[V];
		Arrays.fill(color, 0);
		 if ( 
		            !graphColorUtil( 
		                graph, m, color, 0)) { 
		            System.out.println( 
		                "Solution does not exist"); 
		            return false; 
		        } 
		        printSolution(color); 
		        return true;
	}
	void printSolution(int color[]) 
    { 
        System.out.println( "Solution Exists: Following" + " are the assigned colors"); 
        for (int i = 0; i < V; i++) 
            System.out.print(" " + color[i] + " "); 
        System.out.println(); 
    } 
	public static void main(String[] args) {
		m_Coloring Coloring = new m_Coloring(); 
		 int graph[][] = { 
		             { 0, 1, 1, 1 }, 
		             { 1, 0, 1, 0 }, 
		             { 1, 1, 0, 1 }, 
		             { 1, 0, 1, 0 }, 
		         }; 
		         int m = 3; // Number of colors 
		         Coloring.graphcoloring(graph, m);
	}

}
