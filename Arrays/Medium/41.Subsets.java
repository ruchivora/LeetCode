/*
		Using for loop in recursion .
		Draw the recursion Tree .

		Reference : https://www.youtube.com/watch?v=LdtQAYdYLcE

*/


class Solution 
{
	List<List<Integer>> subsets = new ArrayList<List<Integer>>() ;

  public List<List<Integer>> subsets(int[] nums) 
  {
    ArrayList<Integer> combination = new ArrayList<Integer>() ;
    formSubset( combination , nums , 0 ) ;

    return subsets ;
  }

  public void formSubset( ArrayList<Integer> combination , int nums[] , int startIndex )
  {
  	  /* 
  	 		We write new ArrayList because we have to add 
  	    the copy of combination and not the combination
  	  */
  	subsets.add( new ArrayList<>(combination) ) ;

  	for( int i = startIndex ; i < nums.length ; i++ )
  	{
  		combination.add( nums[ i ] ) ;
  		formSubset( combination , nums , i + 1 )   ;
  		combination.remove( combination.size() - 1 ) ;
  		System.out.println( Arrays.toString( combination ) ) ;	
  	}
  }
}