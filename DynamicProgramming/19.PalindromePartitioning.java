/*
    The code is Proper. 
    But is sometimes giving time Limit Exceeded .

    Question  : https://www.interviewbit.com/problems/palindrome-partitioning-ii/
    Reference : https://www.youtube.com/watch?v=9h10fqkI7Nk&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=38 

*/
    
public class Solution 
{
    public int minCut(String A) 
    {
        char X[] = A.toCharArray() ;
        
        if( isPalindrome( X , 0 , X.length -1  ) )
                return 0 ;
        
        int t[][] = new int[ X.length + 1][ X.length + 1 ] ;
        
        for( int i = 0 ; i <= X.length - 1 ; i++ )
        {
            for( int j = 0 ; j <= X.length -1 ; j++ )
                    t[i][j] = -1 ;
        }
        
        return Partition( X , t , 0 , X.length - 1 ) ;
        
    }

    public int Partition( char X[] , int t[][] , int i , int j )
    {
        int min = Integer.MAX_VALUE ;
        if( i >= j )
           return t[i][j] = 0 ;
           
        if( t[i][j] != -1 )
            return t[i][j] ;
          
        if( isPalindrome( X , i , j) )
                return  t[i][j] = 0  ;
            
        else
        {
            for( int k = i ; k < j ; k++ )
            {
                int left  ;
                int right ;
                
                if( t[i][k] != -1 )
                    left = t[i][k] ;
                else 
                    left = Partition( X , t , i , k ) ;
                    
                if( t[k + 1 ][j] != -1 )
                        right = t[ k + 1 ][j] ;
                else
                    right = Partition( X , t , k+1 , j ) ;
                    
                int temp = 1 + left +right ;
                
                min = Math.min( min , temp ) ;
            }
        }
        return t[i][j] = min ;
    }
    
    
    public boolean isPalindrome( char X[] , int start , int end )
    {
        if( start == end )
                return true ;
                
        int i = start ;
        int j = end ;
        
        while( i <= j )
        {
            if( X[i] == X[j] )
            {
                i++ ;
                j-- ;
            }
            else return false ;
        }
      return true ;
    }
    
}
