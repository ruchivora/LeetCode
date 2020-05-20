/*
	Given an arbitrary ransom note string and another string containing 
	letters from all the magazines, write a function that will return true 
	if the ransom note can be constructed from the magazines ; otherwise, it will return false.

	Each letter in the magazine string can only be used once in your ransom note.
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>() ;

    	for( int i = 0 ; i < magazine.length() ; i++ )
    		 map.put( magazine.charAt(i) , map.getOrDefault( magazine.charAt(i) , 0 ) + 1 ) ;
    	

    	for( int i = 0 ; i < ransomNote.length() ; i++ )
    	{
    		if( ! map.containsKey( ransomNote.charAt(i) ) || map.get( ransomNote.charAt(i) ) == 0 )
    			return false ;
    		else
    			map.put(ransomNote.charAt(i) , map.get( ransomNote.charAt(i) ) - 1 ) ;	
    	}
    	return true ;
    }
}