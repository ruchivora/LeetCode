/*
	Be careful while using .clear() to clear a collection .
*/

class Solution {
    public List<List<Integer>> generate(int numRows) 
    {
     
     List<List<Integer>> result = new LinkedList<List<Integer>>() ;
     if( numRows == 0 ) return result ;

     LinkedList<Integer> currRow = new LinkedList<Integer>() ;

     currRow.add( 1 ) ;
     result.add(currRow) ;

     for( int i = 1 ; i < numRows ; i++ )
     {
      	LinkedList<Integer> temp = new LinkedList<Integer>() ;
     	
     	for( int j = 0 ; j <= i ; j++ )
     	{
     		if( j == 0 || j == i )	temp.add(1) ;
     		else
     		{
     			int sum = result.get(i-1).get(j-1) + result.get(i-1).get(j) ;
     			temp.add(sum) ;
     		}
     	}
     	result.add(temp) ;
     }
     return result ;
    }
}