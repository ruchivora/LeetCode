/*
    Question : https://www.interviewbit.com/problems/add-one-to-number/

    Passed all the test cases including any leading zero in the Array .
    
    The Question is different compared to all other problems on Array .
*/



public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) 
    {
      if( A.size() > 1 )
      {
          int count = 0 ;
           
         for( int  i = 0 ; i < A.size() ; i++ )
         {
              if( A.get(i) == 0 ) count++ ;
              else break ;
          }
           
         for( int i = 0 ; i < count ; i++ )
                    A.remove(0)    
      }
      
      int carry = 1 ;
      
      for( int i = A.size() - 1 ; i >= 0 ; i-- )
      {
          if( A.get(i) == 9 ) 
          {
              A.set( i , 0 ) ;
              carry = 1 ;
          }
          else
          {
              A.set( i , A.get( i ) + carry  );
              carry = 0 ;
              return A ;
          }
      }  
      
      if( carry  == 1 ) 
            A.add( 0 , 1 ) ;
    
    return A ; 
        
    }
}
