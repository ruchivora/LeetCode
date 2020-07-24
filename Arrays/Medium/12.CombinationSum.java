/*
		Important Question . Teaches you about recursion 
		
		Understand the importance of Sorting here .

		Steps : Always start by building Decision Tree .
						Then create recursive Solution .

		Compare the code with recursion problem .

		Reference : https://www.youtube.com/watch?v=irFtGMLbf-s 
*/
class Solution
{
	 List<List<Integer>> result = new ArrayList<>() ;

	 public List<List<Integer>> combinationSum(int[] candidates, int target) 
   {
   		if( candidates == null || candidates.length == 0 )
   				return result ;

   		Arrays.sort( candidates ) ;

   		List<Integer> combination = new ArrayList<>() ;
   		toFindCombinationToTarget( combination , candidates , target , 0  ) ; 

   	 return result ;
   }

 		public void toFindCombinationToTarget( List<Integer> combination , int[] candidates , int target , int startIndex )
 		{
 				if( target == 0 )
 				{
 						result.add( new ArrayList<>(combination) ) ;
 						return ;
 				}

 				for( int i = startIndex ; i < candidates.length ; i++ )
 				{
 					  if( candidates[i] > target )
 					 			break ;

 					 	combination.add( candidates[i] ) ;
 					 	toFindCombinationToTarget( combination , candidates, target - candidates[i] , i ) ;
 					 	combination.remove( combination.size() - 1 ) ;
 				}
 		}
}