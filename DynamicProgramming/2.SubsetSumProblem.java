/*
    This problem is similar to 0/1 Knapsack  . 
    So first solve 0/1 KnapSack . 
  
    Question : https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
    Solution : Write recursive Solution and then convert to Dynamic Programming .
    

    Reference : https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7 
*/



/*
    Recursive Function 
*/

static boolean isSubsetSum( int arr[] , int n , int sum ) 
{
    if( sum == 0 )
        return true ;

    if( n <= 0 ) 
        return false ;

    if( arr[ n - 1 ] <= sum )
      return ( isSubsetSum( arr , n - 1 , sum - arr[ n - 1 ] ) || isSubsetSum( arr , n - 1 , sum ) ) ;

    else
      return isSubsetSum( arr , n - 1 , sum ) ;
}    
/*
    Dynamic Programming Code .
*/
import java.util.Arrays ;
class GFG { 

	static boolean isSubsetSum( int arr[] , int n , int sum ) 
	{ 
       boolean t[][] = new boolean[n+1][sum+1] ;
      
      	for( int i = 0 ; i <= n ; i++ )
        {
          for( int j = 0 ; j <= sum ; j++ )
          {
            if( i == 0 && j == 0)
              		t[i][j] = true ;
            else if( i == 0 )
              	t[i][j] = false ;
            
            else if( j == 0 )
              	     t[i][j] = true ;
            
            else if( arr[i-1] <= j )
					             t[i][j] = t[i-1][j - arr[i-1] ] || t[i-1][j] ;
                  else
                      t[i][j] = t[i-1][j] ;
          }
        }
    return t[n][sum] ; 
	} 

	public static void main(String args[]) 
	{ 
		int set[] = { 3, 6, 14, 12, 5, 10 } ; 
		int sum = 9 ; 
		int n = set.length ;
    return isSubsetSum( set, n , sum ) ;
	} 
} 

