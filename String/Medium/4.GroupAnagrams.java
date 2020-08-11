/*
    Here in anagramList , we have to add all the 
    values of map. So the function map.values() 
    adds all the values of HashMap in anagramList .

    TC : O( N( K log K ) ) Here K = Highest length of the word . 
                                N = Number of elements in the array . 

    SC : O( N ) Here : Number of elements in the array . 
*/

class Solution 
{
  public List<List<String>> groupAnagrams(String[] strs) 
  {
      List<List<String>> anagramList   = new ArrayList<List<String>>() ;

      HashMap<String,List<String>> map = new HashMap<String,List<String>>() ;

      for( int i = 0 ; i < strs.length ; i++ )
      {
        String word = strs[i] ;

        char sortWord[] = word.toCharArray() ;
        Arrays.sort( sortWord ) ;
        String sortedWord = new String( sortWord ) ;

        if( !map.containsKey( sortedWord ) )
              map.put( sortedWord , new ArrayList<String>() ) ;
        
        map.get( sortedWord ).add( word ) ;
      }
      anagramList.addAll( map.values() ) ;

    return anagramList ; 
  }
}