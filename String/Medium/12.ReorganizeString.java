/*
		Logic : Store the frequency of  each character
						in a hash map . 
						Use Priority Queue to store the character 
						that occured highest amount of time .( Max Heap )
						Arrange the String according to frequency of characters .

	  Reference : https://www.youtube.com/watch?v=zaM_GLLvysw

*/

class Solution 
{
  public String reorganizeString(String s) 
  {
      HashMap<Character,Integer> counts = new HashMap<Character,Integer>() ;

      for( int i = 0 ; i < s.length() ; i++ )
      			counts.put( s.charAt(i) , counts.getOrDefault( s.charAt(i) , 0 ) + 1 ) ;

        PriorityQueue<Character> maxHeap = new PriorityQueue<>( ( a , b ) -> counts.get(b) - counts.get(a) ) ;
      	maxHeap.addAll( counts.keySet() ) ;

      	StringBuilder sb = new StringBuilder() ;

      	while( maxHeap.size() > 1 )
      	{
      		char current = maxHeap.remove() ; 
      		char next    = maxHeap.remove() ;
      		sb.append( current ) ;
      		sb.append( next ) ;
      		counts.put( current , counts.get(current) - 1 ) ;
      		counts.put( next , counts.get(next) - 1 ) ;

      		if( counts.get( current ) > 0 )
      					maxHeap.add( current ) ;

      		if( counts.get( next )  > 0 )
      					maxHeap.add( next ) ; 
      	} 

      	if( !maxHeap.isEmpty() )
      	{
      		char last = maxHeap.remove() ;
      		if( counts.get( last ) > 1 )
      					return "" ;
      		sb.append( last ) ;
      	}

      return sb.toString() ;

  }
}