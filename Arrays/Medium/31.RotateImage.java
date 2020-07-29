/*
		Here the main challenge is rotating the matrix inplace .

		Logic : step1 - take the transpose of a matrix . 
											i.e swapping non diagonal elements once .
									- swap the column elements. 
									    i.e if n = 4 . then column 1 will be swapped by column 4 ,
									    col 2 by col 3 etc . 
		Reference : https://www.youtube.com/watch?v=IdZlsG6P17w&t=773s 

*/
class Solution {
    public void rotate(int[][] matrix) 
    {
    		int n = matrix.length ;

        for( int i = 0 ; i < matrix.length ; i++ )
        {
        	 for( int j = i ; j < matrix[0].length ; j++ )
        	 {
        	 		int temp     = matrix[i][j] ;
        	 		matrix[i][j] = matrix[j][i] ;
        	 		matrix[j][i] = temp ; 
        	 }
        }

        for( int i = 0 ; i < matrix.length ; i++ )
        {
        	 for( int j = 0 ; j < (n/2)  ; j++ )
        	 {
        	 		int temp     = matrix[i][j] ;
        	 		matrix[i][j] = matrix[i][ n - 1 - j ] ;
        	 		matrix[i][ n - 1 - j ] = temp ;
        	 }
        }
    }
}