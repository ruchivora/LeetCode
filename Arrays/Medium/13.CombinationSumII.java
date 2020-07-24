/*
		Understand the significance of this Question. 
		How is it different from combination Sum .

		Understand the importance of Sorting here.

		Steps :  Always start by building Decision Tree .
						 Then create recursive Solution .

		Reference : https://www.youtube.com/watch?v=j9_qWJClp64
		Compare the code with recursion problem .


*/

class Solution 
{
		List<List<Integer>> result = new ArrayList<List<Integer>>() ;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
    		Arrays.sort( candidates ) ;
    		ArrayList<Integer> combination = new List<>() ;

        findCombination( candidates , combination , 0 , target  ) ; 

        return result ;
    }

    public void findCombination( int [] candidates , List<Integer> combination ,int startIndex , int target  ) 
    {
    		if( target == 0 )
    		{
    			result.add( new ArrayList<>(combination) ) ; 
    			return ;
    		}

    		for( int i = startIndex ; i < candidates.length ; i++ )
    		{
    			if( i != startIndex && candidates[i] == candidates[i-1] )
    					continue ;

    			if( candidates[i] > target )
    					break ;

    			combination.add( candidates[ i ] ) ;
    			findCombination( candidates , combination, i + 1 , target - candidates[i]  ) ;
    			combination.remove( combination.size() - 1 ) ;
    		}
    }
}

