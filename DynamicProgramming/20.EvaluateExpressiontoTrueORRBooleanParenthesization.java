/*
    Question  : https://www.interviewbit.com/problems/evaluate-expression-to-true/

    Reference : https://www.youtube.com/watch?v=pGVguAcWX4g&t=1521s

*/



public class Solution 
{
    /* Forming Hash map instead of 3-D array .*/
    HashMap<String,Integer> map = new HashMap<String,Integer>()  ;
    
    public int cnttrue(String A) 
    {
        char X[] = A.toCharArray() ;
        
        int x = solve( X , 0 , X.length - 1 , true ) ;
        
        return x ;
    }
    
    int solve( char X[] , int i , int j , boolean isTrue )
    {
        if( i > j ) return 0 ;
        
        StringBuilder temp = new StringBuilder() ;
        
        /* Forming Key as i_j_true || i_j_false */
        temp.append(i)   ;
        temp.append("_") ;
        temp.append(j)   ;
        temp.append("_") ;
        temp.append( isTrue ) ;
        
        String str1 = temp.toString() ;
        
        if( i == j )
        {
            if( isTrue == true )
            {
                if( X[i] == 'T' )
                {
                     map.put( str1 , 1 ) ;
                     return 1 ;
                }
                else
                {
                    map.put( str1 , 0 ) ;
                    return  0 ;
                }
            }
            else
            {
                if( X[i] == 'F' )
                {
                    map.put( str1 , 1 ) ;
                    return 1 ;
                }
                else
                {
                    map.put( str1 , 0 ) ;
                    return 0 ;
                }
            }
        }
        
        if( map.containsKey( str1 ) )
                return map.get( str1 ) ;
                
        int ans = 0 ;
        
        for( int k = i + 1 ; k <= j - 1 ; k = k + 2 )
        {
            int LT = solve( X , i , k - 1 , true  ) ;
            int LF = solve( X , i , k - 1 , false ) ;
            int RT = solve( X , k + 1 , j , true  ) ;
            int RF = solve( X , k + 1 , j , false ) ;
            
            if( X[k] == '&' )
            {
                if( isTrue == true )
                    ans = ans + LT * RT ;
                else
                   ans = ans + LT * RF + LF * RT + LF * RF ;
            }
            
            if( X[k] == '|' )
            {
                if( isTrue == true )
                    ans = ans + LT * RF + LT * RT + LF * RT ;
                else
                    ans = ans + LF * RF ; 
            }
            if( X[k] == '^' )
            {
                if( isTrue == true )
                    ans = ans + LT * RF + LF * RT ;
                else 
                    ans = ans + LF * RF + LT * RT ;
            }
        }
           
        map.put( str1 , ans ) ;     
        return ans % 1003 ;
    }
}
