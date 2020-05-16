/*

	(This problem is an interactive problem.)

	A binary matrix means that all elements are 0 or 1. 
	For each individual row of the matrix, this row is sorted in non-decreasing order.

	Given a row-sorted binary matrix binaryMatrix, return leftmost column 
	index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

	You can't access the Binary Matrix directly.  You may only access the matrix 
	using a BinaryMatrix interface:

	BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
	BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
	Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. 
	Also, any solutions that attempt to circumvent the judge will result in disqualification.

	For custom testing purposes you're given the binary matrix mat as input in the 
	following four examples. You will not have access the binary matrix directly.
	
	Hint : https://www.youtube.com/watch?v=TYH5uCkCfx4
	
*/
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

    	List<Integer> list = binaryMatrix.dimensions() ;
    	int row = list.get( 0 ) ;
    	int col = list.get( 1 ) ;
    	int column = col - 1 ;
    	boolean in = false ;
    	
    	for( int i = 0 ; i < row ; i++ )
    	{
    		for( int j = column ; j >= 0 ; j-- )
    		{
    			if( binaryMatrix.get( i , j ) == 1 )
    			{
    				in = true ;
    				column = (column > j) ? j : column ;

    				if( j == 0 )
    					break ;
    			}
    			else 
    				break ;
    		}
    	}
       return (  in == true  ) ? column : -1;
    }
}