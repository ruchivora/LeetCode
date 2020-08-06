/*
    Read the Question carefully ! .

    Return the destination city, that is, the 
    city without any " path outgoing to another city. "
    It is guaranteed that the graph of paths forms a line 
    without any loop, therefore, there will be exactly one 
    destination city.

    So , the destination is the one where their is no 
    outgoing edge . 

    Logic : First store all the destination state and 
            then remove all the states which are reachable
            from the source . because the Question clearly 
            says that destination has no outgoing edge .  
*/

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