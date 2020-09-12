package Graphs;
import java.util.*;
public class MinimumCostPath {
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	static int D;
	MinimumCostPath(int v){
		D=v;
	}
	static class Cell{
		int x;
		int y;
		int distance;
		Cell(int x,int y,int distance){
			this.distance=distance;
			this.x=x;
			this.y=y;
		}
	}
	static class DistanceComparator implements Comparator<Cell>{

		@Override
		public int compare(Cell o1, Cell o2) {
			if(o1.distance<o2.distance)
				return -1;
			if(o1.distance>o2.distance)
				return 1;
			return 0;
		}
	}
	static boolean isInside(int x,int y) {
		return (x>=0 && x<D && y>=0 &&y<D);
	}
	static int ShortestPath(int grid[][]) {
		int dist[][]=new int[D][D];
		for(int i=0;i<D;i++)
			for(int j=0;j<D;j++)
				dist[i][j]=Integer.MAX_VALUE;
		
		dist[0][0]=grid[0][0];
		PriorityQueue<Cell> pq=new PriorityQueue<Cell>(D*D,new DistanceComparator());
		pq.add(new Cell(0,0,dist[0][0]));
		while(!pq.isEmpty()) {
			Cell curr=pq.poll();
			for(int i=0;i<4;i++) {
				int rows=curr.x+dx[i];
				int cols=curr.y+dy[i];
				if(isInside(rows,cols)) {
					if(dist[rows][cols]>dist[curr.x][curr.y]+grid[rows][cols]) {
						if(dist[rows][cols]!=Integer.MAX_VALUE) {
							Cell adj=new Cell(rows,cols,dist[rows][cols]);
							pq.remove(adj);
						}
						dist[rows][cols] = dist[curr.x][curr.y] + grid[rows][cols]; 
                        pq.add(new Cell(rows, cols,  
                        dist[rows][cols])); 
					}
				}
			}
		}
		return dist[D-1][D-1];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int D=sc.nextInt();
		int grid[][]=new int[D][D];
		for(int i=0;i<D;i++)
			for(int j=0;j<D;j++)
				grid[i][j]=sc.nextInt();
		MinimumCostPath g=new MinimumCostPath(D);
		System.out.println(g.ShortestPath(grid));
	}

}
