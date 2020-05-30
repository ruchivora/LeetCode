/*
	Given a string s and a non-empty string p, 
	find all the start indices of p's anagrams in s.

	Strings consists of lowercase English letters 
	only and the length of both strings s and p will not be larger than 20,100.

	The order of output does not matter.
	Example 1:
	Input:
	s: "cbaebabacd" p: "abc"

	Output:[0, 6]
	Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc".
	             The substring with start index = 6 is "bac", which is an anagram of "abc".
	
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
    List<Integer> ans = new ArrayList<Integer>() ;

    if( s.length() == 0 || s == null)
    	return ans ;

    int char_count[] = new int[26] ;

    for( int i = 0 ; i < p.length() ; i++) 
    {
    	char_count[p.charAt(i) - 'a'] += 1 ;
    }

    int left  = 0 ;
    int right = 0 ;
    int count = p.length() ;

    while( right < s.length() )
    {
    	if( char_count[s.charAt(right++) - 'a']-- >= 1 )
    	{
    		count-- ;
    	}
    	if( count == 0 )
    		ans.add( left ) ;

    	if( right - left == p.length() && char_count[s.charAt(left++) - 'a']++ >= 0  )
    	{
    		count++ ;
    	}
    }

       return ans ;
    }
}