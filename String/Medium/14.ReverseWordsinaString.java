/*
		Try removing space without using any inbuilt function .

*/

class Solution {
  public String reverseWords( String s ) 
  {
      String sb  = s.trim().replaceAll(" +" ," " ) ;
      String arr[] = sb.split( " " ) ;
      int left  = 0 ;
      int right = arr.length - 1 ;
      StringBuilder build = new StringBuilder() ;

      while( left <= right )
      {
      	String temp = arr[left] ;
      	arr[left]   = arr[right] ;
      	arr[right]  = temp ;
      	left++ ;
      	right-- ;
      }

      for( int i = 0 ; i < arr.length ; i++ )
      {
      	build.append( arr[i] ) ;

      	if( i < arr.length - 1 ) 
      	 		build.append( " " ) ;
      }   
    return build.toString()  ;
  }
}