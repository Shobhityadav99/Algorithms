package Graphs;

public class N_Queens {
	final int N=4;
	void printSolution(int board[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
	boolean isSafe(int row,int col,int board[][]) {
		int i,j;
		for(i=0;i<col;i++)
			if(board[row][i]==1)
				return false;
		for(i=row,j=col;i>=0 && j>=0;i--,j--)
			if(board[i][j]==1)
				return false;
			for(i=row,j=col;j>=0 && i<N;i++,j--)
				if(board[i][j]==1)
					return false;
			return true;
		}
	boolean solveQUtil(int board[][],int col) {
		if(col>=N)
			return true;
		for(int i=0;i<N;i++) {
			if(isSafe(i,col,board)) {
				board[i][col]=1;
				if(solveQUtil(board,col+1))
					return true;
				board[i][col]=0;
			}
		}
		return false;
	}
	void Solve() {
		 int board[][] = { { 0, 0, 0, 0 }, 
                 { 0, 0, 0, 0 }, 
                 { 0, 0, 0, 0 }, 
                 { 0, 0, 0, 0 } }; 

		 if (solveQUtil(board, 0) == false) { 
			 System.out.print("Solution does not exist");
			 } 
		 printSolution(board); 
	}
	public static void main(String[] args) {
		N_Queens Queen = new N_Queens(); 
	        Queen.Solve(); 
	}

}
