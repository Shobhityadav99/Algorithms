package Graphs;

public class n_Queen_indefined_Space {
	static void breakline() {
		System.out.print("\n---------------------------------\n"); 
	}
	static int Max=10;
	static int arr[]=new int[Max], no;
	static void queens(int k,int n) {
		for(int i=1;i<=n;i++) {
			if(canPlace(k,i)) {
				arr[k]=i;
				if(k==n) {
					display(n);
				}
				else
					queens(k+1,n);
			}
		}
	}
	static boolean canPlace(int k,int i) {
		for(int j=1;j<=k-1;j++) {
			if(arr[j]==i || (Math.abs(arr[j]-i)==Math.abs(j-k)))
				return false;
		}
		return true;
	}
	 static void display(int n) 
	    { 
		 breakline(); 
	        System.out.print("Arrangement No. " + ++no); 
	        breakline(); 
	  
	        for (int i = 1; i <= n; i++) 
	        { 
	            for (int j = 1; j <= n; j++)  
	            { 
	                if (arr[i] != j)  
	                { 
	                    System.out.print("\t_"); 
	                } 
	                else 
	                { 
	                    System.out.print("\tQ"); 
	                } 
	            } 
	            System.out.println(""); 
	        } 
	  
	        breakline(); 
	    } 
	public static void main(String[] args) {
		int n = 4; 
        queens(1, n);
	}

}
