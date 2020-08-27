/*
    Question : https://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/

*/


import java.util.*;

class ArrPathSum1
{
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		GfG g = new GfG();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}// } Driver Code Ends


class GfG
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int ar1[], int ar2[])
    {
        int maxSum = 0 ; 
        int ptr1 = 0 ; 
        int ptr2 = 0 ; 
        int sumA = 0 ; 
        int sumB = 0 ; 
        
        while( ptr1 < ar1.length && ptr2 < ar2.length )
        {
            if( ar1[ptr1] < ar2[ptr2] )
            {
                sumA = sumA + ar1[ptr1] ;
                ptr1++ ;
            }
            else if( ar1[ptr1] > ar2[ptr2] )
            {
                sumB = sumB + ar2[ptr2] ;
                ptr2++;
            }
            else if( ar1[ptr1] == ar2[ptr2] )
            {
                int max = ( sumA > sumB ) ? sumA : sumB ; 
                maxSum  = maxSum + max + ar1[ptr1] ;
                ptr1++ ;
                ptr2++ ;
                sumA = 0 ; 
                sumB = 0 ; 
            }
        }
        
        while( ptr1 < ar1.length )
                sumA = sumA + ar1[ptr1++] ;
        
        while( ptr2 < ar2.length )
                sumB = sumB + ar2[ptr2++] ;
        
        int max = ( sumA > sumB ) ? sumA : sumB ;
        maxSum  = maxSum + max ; 
        
      return maxSum ;
    }
}