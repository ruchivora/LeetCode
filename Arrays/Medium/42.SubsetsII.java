/*
		Form the Recursion tree . 
		That consists of writing index along with the combination .
		And why do we need for loop ? 
			- You will understand once you draw recursion tree .

		Reference : https://www.youtube.com/watch?v=lCvL8htQ1iI

*/


class Solution 
{
	List<List<Integer>> subset = new ArrayList<List<Integer>>() ;

  public List<List<Integer>> subsetsWithDup(int[] nums) 
  {
  	if( nums.length == 0 || nums == null )
  			return subset ;

  	Arrays.sort( nums ) ; 
    ArrayList<Integer> combination = new ArrayList<Integer>() ;
    formPowerSet( combination , nums , 0 ) ;

    return subset ; 
  }

  public void formPowerSet( ArrayList<Integer> combination , int nums[] , int startIndex )
  {
  	subset.add( new ArrayList<>( combination ) ) ; 

  	for( int i = startIndex ; i < nums.length ; i++ )
  	{
  		if( i != startIndex && nums[i] != nums[ i - 1] )
  					continue ;

  		/* 
  			I got confused here . Because i thought the statement should be
  			if( i != startIndex && nums[i] != nums[ i - 1] ) 
  				{
						combination.add( nums[i] ) ;
  					formPowerSet( combination , nums , i + 1 ) ;
  					combination.remove( combination.size() - 1 ) ;
  				}
				But this is not working ! . Because this is not feasible for every 
				iteration . So continue is the only solution to jump to next loop
				iteration !. 
			
  		*/
  		combination.add( nums[i] ) ;
  		formPowerSet( combination , nums , i + 1 ) ;
  		combination.remove( combination.size() - 1 ) ;

  	}
  }
}