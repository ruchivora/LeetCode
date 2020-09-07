// { Driver Code Starts
import java.util.*;

class Matrix_In_Diagonal_Pattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n= sc.nextInt();
			int a[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j] = sc.nextInt();
				}
			}
			GfG g = new GfG();
			g.printMatrixDiagonal(a,n);
			System.out.println();
		t--;
		}
	}
}// } Driver Code Ends


class GfG
{
    /*You are required to complete this method */
    void printMatrixDiagonal(int mat[][], int n)
    {
        boolean isUp = true ; 
        int i = 0 ;
        int j = 0 ; 
        int k = 0 ; 
        
        /* increase col number and decrease row number if direction is Up*/

        while( k < n*n )
        {
            if( isUp )
            {
                while( i >= 0 && j < n )
                {
                    System.out.print( mat[i][j] + " ") ;
                    j++ ;
                    i-- ;
                    k++ ;
                }
                if( i < 0 && j <= n - 1 ) /* If i goes out of range then set it to 0 .*/
                        i = 0 ; 
                if( j == n )
                {
                    i = i + 2 ;
                    j-- ;
                }
            }		
            else   /* increase row number and decrease col number if direction is Up*/
            {
                while( j >= 0 && i < n )
                {
                    System.out.print( mat[i][j] + " " ) ;
                    j-- ; 
                    i++ ; 
                    k++ ;
                }
                if( j < 0 && i <= n - 1 ) /* If j goes out of range then set it to 0 .*/
                        j = 0 ;
                if( i == n )
                {
                    j = j + 2 ;
                    i-- ; 
                }
            }
            isUp = !isUp ; 
        }
        
    }

}