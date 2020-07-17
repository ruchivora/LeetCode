/*
		Reference : https://www.youtube.com/watch?v=TzIuVm1npgw
								https://www.geeksforgeeks.org/count-pairs-array-whose-sum-divisible-4/

		Logic     : There are only three condition that can arise whose sum is divisible by ‘4’ i.e,
								1. If both are divisible by 4.
								2. If one of them is equal to 1 modulo 4 and other is 3 modulo 4. 
									 For instance, (1, 3), (5, 7), (5, 11).
								3. If both of them is equal to 2 modulo 4 i.e., (2, 2), (2, 6), (6, 10)	

		Basically if we have a number , then we try to find whether the other half exists in 
		the hash or not .
*/


class Solution 
{
    public int numPairsDivisibleBy60(int[] time) 
    {
    	 return numDivisibleByk( time , 60 ) ;
    }

    public int numDivisibleByk( int time[] , int k )
    {
    		int hash []  = new int[k] ;
    		int answer = 0 ;

    		for( int i = 0 ; i < time.length ; i++ )
    		{
    				int current  = time[i] % k ; 
    				int opposite = ( k - current ) ;

    				answer = answer + hash[opposite] ;
    				hash[current]++ ;
    		}
    	return answer ;
    }
}


/* Recurrence Solution based on decision Tree .*/
class Solution 
{
		int count = 0 ; 
    public int numPairsDivisibleBy60(int[] time) 
    {
        int data[] = new int[2]  ;
        int N      = time.length ;

       	calculateCount( time , 0 , data , 0 ) ;
       	return count ;    
    }

    public void calculateCount( int time[] , int index , int data[] , int dataIndex )
    {
       
	    	if( dataIndex == data.length )
	    	{
	    			if( (data[0] + data[1]) % 60 == 0 ) 
	    				count++ ; 
	    			return  ;
	    	}

	    	if( index >= time.length )
	    				return ;

	    	if( dataIndex == 0 || (data[0] + time[index]) % 60 == 0 )
	    	{
	    		data[dataIndex] = time[index] ;
	    		calculateCount( time , index + 1 , data , dataIndex + 1 ) ;
	    		calculateCount( time , index + 1 , data , dataIndex     ) ;
	    	}
	    	else
	    		calculateCount( time , index + 1 , data , dataIndex     ) ;
    }
}