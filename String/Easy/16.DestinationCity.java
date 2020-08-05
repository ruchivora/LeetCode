class Solution 
{
  public String destCity(List<List<String>> paths) 
  {
  	HashSet<String> destination = new HashSet<String>() ;

  	for( int i = 0 ; i < paths.size() ; i++ )
  				destination.add( paths.get(i).get( paths.get(i).size() - 1 ) ) ;
  	
  	for( int i = 0 ; i < paths.size() ; i++ )
  	{
  		if( destination.contains( paths.get(i).get(0) ) )
  					destination.remove( paths.get(i).get(0) ) ;
  	}

  	/*
  		 How to get element from a Set ? 
  		  - The set will always contain only one element .
  		  - So convert it to array and then return that element .
  	*/

  	if( destination.size() == 1 )
  	{
  		String ans = destination.toArray( new String[1] )[0] ;
  		return ans ;
  	}
  	
  return "sad" ;

  }
}