
class Solution {
    public int longestWPI(int[] hours) 
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans = 0 ; 
        int score = 0 ;
        int size = hours.length ;

        for( int i = 0 ; i < size ; i++ )
        {
          score += ( hours[i] > 8 ) ? 1 : -1 ;

          if( score > 0 )
              ans = i + 1 ;
          else
          {
            /*
              check if same score occur twice in map then in that 
              interval there are equal no of tiring and non tiring day
            */
            map.putIfAbsent( score , i ) ; 
            if( map.containsKey( score - 1) )
               ans = Math.max( ans , i - map.get(score-1) );
          }
        }
      return ans ;
    }
}