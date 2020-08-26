/* 
    Optimized ( Smart ) Approach . 
    Here the approach is for each iteration add 1 at the start index .
*/

class Solution 
{
  public List<Integer> getRow(int rowIndex) 
  {
    List<Integer> ret = new LinkedList<Integer>();

      for( int i = 0 ; i <= rowIndex ; i++ ) 
      {
          ret.add(0, 1) ;

          for( int j = 1 ; j < i ; j++ )
                  ret.set( j , ret.get(j) + ret.get( j + 1 ) );
      }
    return ret;
  }
}
