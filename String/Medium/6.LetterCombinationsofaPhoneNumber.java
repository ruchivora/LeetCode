/*
		Here the basic idea is to take one number and consider
		all its character elements . And then consider next
		digit and consider its corrsp character element and 
		form combination with previously pushed elements .

		The Question can also be solved by backtracking - i.e Depth First Search ! 

		Reference : https://www.youtube.com/watch?v=21OuwqIC56E&t=31s

*/

class Solution 
{
  public List<String> letterCombinations( String digits ) 
  {
      List<String> combination = new ArrayList<String>() ;

      if( digits == null || digits.length == 0 )
      			return combination ; 

      HashMap<Character,String> map = new HashMap<Character,String>() ;
      map.put( '2' , "abc" ) ;
      map.put( '3' , "def" ) ;
      map.put( '4' , "ghi" ) ;
      map.put( '5' , "jkl" ) ;
      map.put( '6' , "mno" ) ;
      map.put( '7' , "pqrs") ;
      map.put( '8' , "tuv" ) ;
      map.put( '9' , "wxyz") ;

      char[] digit = digits.toCharArray() ;

      for( int i = 0 ; i < digit.length ; i++ )
      {
      		String s = map.get( digit[i] ) ;

      		if( i == 0 )
      		{
      			for( int j = 0 ; j < s.length() ; j++ )
      							combination.add( Character.toString( s.charAt(j) ) ) ;
      		}
      		else
      		{
      			for( int j = combination.size() - 1 ; j >= 0 ; j-- )
      			{
      				String x = combination.remove( j ) ;
      			
      					for( int k = 0 ; k < s.length() ; k++ )
      					{
      						StringBuilder sb = new StringBuilder() ; 
      						sb.append(x) ;
      						sb.append( s.charAt(k) ) ;
      						combination.add( sb.toString() ) ;
      					}
      			}
      		}
      }

    return combination ; 
  }
}