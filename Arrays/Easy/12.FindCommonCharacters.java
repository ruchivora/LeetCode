/* 
		Good Question .
		
		String does not require hash map . 
		Instead just create an array of 26 characters .

		Logic : We find common element amongst the two String .
					  The answer obtained is compared with the next String .
					  Like wise the Loop is used to find out the final answer .
*/

class Solution {
    public List<String> commonChars(String[] A) 
    {
    		List<String> result = new ArrayList<String>() ;
        int minFreq[]       = new int [26] ;

        Arrays.fill( minFreq , Integer.MAX_VALUE ) ;

        for( int i = 0 ; i < A.length ; i++ )
        {
        		int charFreq [] = new int [26] ;

        		for( int j = 0 ; j < A[i].length() ; j++ )
        					charFreq[ A[i].charAt(j) - 'a' ]++ ;
        		
        		for( int k = 0 ; k < 26 ; k++ )
        					minFreq[k] = Math.min( minFreq[k] , charFreq[k] ) ; 
        }

        for( int i = 0 ; i < 26 ; i++ )
        {
        		/* Loop is used to find out the duplicate characters . */
        		while( minFreq[i] > 0 )
        		{
        			/* Here we have to convert char to String . */
        			result.add( ""+(char)( i + 'a' ) ) ;
        			minFreq[i]-- ;
        		}
        }
      return result ;
    }
}