package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceFromaGuardInBank {
	int M=5;
	int N=5;
	class Node{
		int i,j,dist;
		Node(int i,int j,int dist){
			this.i=i;
			this.j=j;
			this.dist=dist;
		}
	}
	int row[]= {-1,0,1,0};
	int col[]= {0,1,0,-1};
	boolean isValid(int i,int j) {
		 if ((i < 0 || i > M - 1) || (j < 0 || j > N - 1)) 
		        return false; 
		  
		    return true; 
	}
	boolean isSafe(int i,int j,char matrix[][],int output[][]) {
		if(matrix[i][j]!='O' || output[i][j]!=-1)
			return false;
		return true;
	}
	void findDistance(char matrix[][]) {
		int output[][]=new int[M][N];
		Queue<Node> q=new LinkedList<Node>();
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				output[i][j]=-1;
				if(matrix[i][j]=='G') {
					q.add(new Node(i,j,0));
					output[i][j]=0;
				}
			}
		}
		while(!q.isEmpty()) {
			Node curr=q.peek();
			int x=curr.i;
			int y=curr.j;
			int dist=curr.dist;
			for(int i=0;i<4;i++) {
				if(isValid(x+row[i],y+col[i])){
					if(isSafe(x+row[i],y+col[i],matrix,output) ) {
					output[x+row[i]][y+col[i]]=dist+1;
					q.add(new Node(x+row[i],y+col[i],dist+1));
				}
				}
			}
			q.poll();
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(output[i][j]+" ");
			}
			System.out.println();
			}
	}
	public static void main(String args[]) {
		char matrix[][] = 
		    { 
		        {'O', 'O', 'O', 'O', 'G'}, 
		        {'O', 'W', 'W', 'O', 'O'}, 
		        {'O', 'O', 'O', 'W', 'O'}, 
		        {'G', 'W', 'W', 'W', 'O'}, 
		        {'O', 'O', 'O', 'O', 'G'} 
		    }; 
		MinDistanceFromaGuardInBank g=new MinDistanceFromaGuardInBank();
		g.findDistance(matrix);
	}
}
