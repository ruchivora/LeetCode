class Solution {
	public int[] findDiagonalOrder(List<List<Integer>> nums) 
	{
			List<Integer> result = new ArrayList<Integer>() ;

			if( nums.size() == 1 ) 
			{
					for( int i = 0 ; i < nums.get(0).size() ; i++ )
								result.add( nums.get(0).get(i) ) ;

				return answer( result ) ;
			}

			for( int i = 0 ; i < nums.size() ; i++ )
			{
					int index = 0 ;

					for( int j = i ; j >= 0 ; j-- )
					{
								if( nums.get(j).size() - 1 >= index )
								{
									int temp = nums.get(j).get(index++) ;
									result.add( temp ) ;
								}
								else index++ ;			
					}
			}

			/* Elements after rows */

			for( int i = 1 ; i < nums.get( nums.size() - 1 ).size() ; i++ )
			{
					int index = i ; 

					for( int j = nums.size() - 1 ; j >= i  ; j-- )
					{
							System.out.println( nums.get(j).get(index) ) ;

							if( nums.get(j).size() - 1 >= index )
							{
								int temp = nums.get(j).get( index++ ) ;
								result.add( temp ) ;
							}	
							else index++ ;
					}
			}
		return answer( result ) ;
	}

	public int[] answer( List<Integer> result )
	{
			int ans [] = new int[ result.size() ] ;
			for( int i = 0 ; i < result.size() ; i++ )
							ans[i] = result.get(i) ;
		return ans ;
	}


}