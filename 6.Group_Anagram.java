/*
    Group Anagrams

    Given an array of strings, group anagrams together.
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
            [
              ["ate","eat","tea"],
              ["nat","tan"],
              ["bat"]
            ]
    Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
                
      List<List<String>> Anagram = new ArrayList () ;
      HashMap<String,List<String>> map = new HashMap<String,List<String>> () ; 

      for( int i = 0 ; i < strs.length ; i++  )
      {
        char word [] = strs[i].toCharArray() ;
        Arrays.sort(word) ;
        String temp = new String(word) ;
        
        if( !map.containsKey(temp) )
        {
          map.put(temp,new ArrayList<String>() ) ;
        }
        map.get(temp).add(strs[i]) ;
      }
    Anagram.addAll(map.values()) ;



    return Anagram ;



    }
}