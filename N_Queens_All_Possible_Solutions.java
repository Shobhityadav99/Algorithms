package Graphs;

public class N_Queens_All_Possible_Solutions {
static int N = 4; 
static int k = 1; 
static void printSolution(int board[][]) 
{ 
	System.out.printf("%d-\n", k++); 
	for (int i = 0; i < N; i++) 
	{ 
		for (int j = 0; j < N; j++) 
			System.out.printf(" %d ", board[i][j]); 
		System.out.printf("\n"); 
	} 
	System.out.printf("\n"); 
}
static boolean isSafe(int board[][], int row, int col) 
{ 
	int i, j; 
	for (i = 0; i < col; i++) 
		if (board[row][i] == 1) 
			return false; 

	/* Check upper diagonal on left side */
	for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
		if (board[i][j] == 1) 
			return false; 

	/* Check lower diagonal on left side */
	for (i = row, j = col; j >= 0 && i < N; i++, j--) 
		if (board[i][j] == 1) 
			return false; 

	return true; 
} 
static boolean solveNQUtil(int board[][], int col) 
{ 
	if (col == N) 
	{ 
		printSolution(board); 
		return true; 
	} 
	boolean res = false; 
	for (int i = 0; i < N; i++) 
	{ 
		if ( isSafe(board, i, col) ) 
		{ 
			board[i][col] = 1; 
			res = solveNQUtil(board, col + 1) || res; 
			board[i][col] = 0; 
		} 
	} 
	return res; 
} 
static void solveNQ() 
{ 
	int board[][] = new int[N][N]; 

	if (solveNQUtil(board, 0) == false) 
	{ 
		System.out.printf("Solution does not exist"); 
		return ; 
	} 

	return ; 
} 
public static void main(String[] args) 
{ 
	solveNQ(); 
} 	}
