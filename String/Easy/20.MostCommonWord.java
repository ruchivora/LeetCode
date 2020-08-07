/*
		This Question teaches how to deal with Strings .
		And how to manipulate Strings . 

		Logic : Remove punctuations and spaces and then use set
						to put Banned words and use hashMap to keep track
						of frequency of occurance of each word .  
*/
class Solution 
{
	public String mostCommonWord(String paragraph, String[] banned) 
	{
	    HashSet<String> set = new HashSet<String>() ;
	    /* Removes Punctuation and converts to lower case . */
	    paragraph = paragraph.replaceAll("\\p{Punct}", " ").toLowerCase() ;
	    paragraph = paragraph.replaceAll("( +)"," ").trim() ;
	   
	    String [] para = paragraph.split( " " ) ;
	    
	    HashMap<String,Integer> map = new HashMap<String,Integer>() ;
	    int max = 0 ;
	    String result = "" ;

	    for( int i = 0 ; i < banned.length ; i++ )
	    				set.add( banned[i] ) ;

	    for( int i = 0 ; i < para.length ; i++ )
	    {
	    	if( !set.contains( para[i] ) && para[i] != " " )
	    				map.put( para[i] , map.getOrDefault( para[i]  , 0 ) + 1 ) ;
	    }

	    for( int i = 0 ; i < para.length ; i++ )
	    {
    		if( map.containsKey( para[i] ) &&  map.get( para[i] ) > max)
    		{
    			max = map.get( para[i] ) ;
    			result = para[i] ;
    		}
	    }


	  return result;
	}
}