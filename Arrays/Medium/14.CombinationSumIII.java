/*
		Important Question . Teaches you about recursion

		Understand the Question .

		Approach : Write the recursion Tree .
							 Then find out how does it exists .

		Then try to write plain recursion without for loop .
		Then write recursion with for loop . You will
		understand the difference .		

*/

class Solution 
{
		List<List<Integer>> result = new ArrayList<List<Integer>> () ;

    public List<List<Integer>> combinationSum3(int k, int target) 
    {
    		List<Integer> combination = new ArrayList<>() ;

        findCombination( 1 , k , target , combination ) ;

        return result ;
    }

    public void findCombination( int startIndex , int k , int target , List<Integer> combination )
    {
    	if( k == 0 && target == 0 )
    	{
    		result.add( new ArrayList<>( combination ) ) ;
    		return ;
    	}
    	if( k == 0 )
    			return  ;

    	for( int i = startIndex ; i <= 9 ; i++ )
    	{
    		if( i <= target )
    		{
    			combination.add( i ) ;
    			findCombination( i + 1 , k - 1 , target - i , combination ) ;
    			combination.remove( combination.size() - 1 ) ;
    		}
    		else break ;
    	}
    }
}