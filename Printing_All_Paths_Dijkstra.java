package Graphs;

public class Printing_All_Paths_Dijkstra {
	private static final int NO_PARENT=-1;
	public static void dijkstra(int graph[][],int src) {
		int V=graph[0].length;
		int shortestDist[]=new int[V];
		boolean added[]=new boolean[V];
		for(int i=0;i<V;i++) {
			shortestDist[i]=Integer.MAX_VALUE;
			added[i]=false;
		}
		shortestDist[src]=0;
		int parents[]=new int[V];
		parents[src]=NO_PARENT;
		for(int i=1;i<V;i++) {
			int near=-1;
			int shortD=Integer.MAX_VALUE;
			for(int k=0;k<V;k++) {
				if(!added[k] && shortestDist[k]<shortD) {
					shortD=shortestDist[k];
					near=k;
				}
			}
			added[near]=true;
			for(int k=0;k<V;k++) {
				int edgeD=graph[near][k];
				if(edgeD>0 && (shortD+edgeD)<shortestDist[k]) {
					parents[k]=near;
					shortestDist[k]=shortD+edgeD;
				}
			}
		}
		 printSolution(src, shortestDist, parents); 
    } 
    private static void printSolution(int startVertex, int[] distances,  int[] parents) 
    { 
        int nVertices = distances.length; 
        System.out.print("Vertex\t Distance\tPath"); 
          
        for (int vertexIndex = 0;  
                 vertexIndex < nVertices;  
                 vertexIndex++)  
        { 
            if (vertexIndex != startVertex)  
            { 
                System.out.print("\n" + startVertex + " -> "); 
                System.out.print(vertexIndex + " \t\t "); 
                System.out.print(distances[vertexIndex] + "\t\t"); 
                printPath(vertexIndex, parents); 
            } 
        } 
    } 
    private static void printPath(int currentVertex, int[] parents) 
    { 
        if (currentVertex == NO_PARENT) 
        { 
            return; 
        } 
        printPath(parents[currentVertex], parents); 
        System.out.print(currentVertex + " "); 
    } 
    public static void main(String[] args) 
    { 
        int[][] adjacencyMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                    { 0, 0, 4, 0, 10, 0, 2, 0, 0 }, 
                                    { 0, 0, 0, 14, 0, 2, 0, 1, 6 }, 
                                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        dijkstra(adjacencyMatrix, 0); 
    } 
} 