package Graphs;

public class Number_of_Islands {
	int ROW,COL;
	Number_of_Islands(int r,int c){
		ROW=r;
		COL=c;
	}
	boolean isSafe(int M[][],int r,int c,boolean visited[][]) {
		return (r>=0) && (r<ROW) && (c>=0) && (c<COL) && (M[r][c]==1) && (!visited[r][c]);
	}
	void DFS(int M[][],int r,int c,boolean visited[][]) {
		int dx[]= {-1,-1,-1,0,0,1,1,1};
		int dy[]= {-1,0,1,-1,1,-1,0,1};
		visited[r][c]=true;
		for(int k=0;k<8;k++)
			if(isSafe(M,r+dx[k],c+dy[k],visited))
				DFS(M,r+dx[k],c+dy[k],visited);
	}
	int countIsland(int M[][]) {
		boolean visited[][]=new boolean[ROW][COL];
		int count=0;
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				if((M[i][j]==1) && !visited[i][j]) {
					DFS(M,i,j,visited);
					++count;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int r=5;
		int c=5;
		Number_of_Islands g=new Number_of_Islands(r,c);
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
            { 0, 1, 0, 0, 1 }, 
            { 1, 0, 0, 1, 1 }, 
            { 0, 0, 0, 0, 0 }, 
            { 1, 0, 1, 0, 1 } }; 
            System.out.print(g.countIsland(M));
	}

}
