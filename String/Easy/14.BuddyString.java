/*
		The Question has really weired Test cases
		that makes this problem unnecessarily complex .

*/

class Solution 
{
  public boolean buddyStrings(String A, String B) 
  {
    if( A.length() != B.length() ) return false ;

    /* 
    	Below code is for testcase :
    	eg: 'a' , 'a' should not pass but 'aa' , 'aa' 
    	should pass this testcase .
    */

    if( A.equals( B ) )
    {
    	HashSet<Character> uniqueChar = new HashSet<Character>() ;

    	for( int i = 0 ; i < A.length() ; i++ )
    				uniqueChar.add( A.charAt(i) ) ;

    	if( uniqueChar.size() < A.length() )
    				return true ;
    	else return false ;
    }

    List<Integer> diff = new ArrayList<Integer>() ;

    for( int i = 0 ; i < A.length() ; i++ )
    {
    	if( A.charAt(i) != B.charAt(i) )
    				diff.add( i ) ;
    }

    /* 	
    		We require condition 
    		A.charAt( diff.get(0) ) == B.charAt( diff.get(1) ) &&
    	  B.charAt( diff.get(0) ) == A.charAt( diff.get(1) )
    	  because then only the two strings would become buddy
    	  String .

    */

    if( diff.size() == 2 && 
    	  A.charAt( diff.get(0) ) == B.charAt( diff.get(1) ) &&
    	  B.charAt( diff.get(0) ) == A.charAt( diff.get(1) ) 
    	)
    	{
    		return true ;
    	}
    	else return false ; 
  }

}