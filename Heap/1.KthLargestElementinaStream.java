/*
		When is Heap datastructure used ? 
		Heap is used when we have to constantly find minimum or
		the maximum element from a group of elements  .

		To implement Heap , Priority Queue is used .

		Solution : To find Kthlargest element , create a priority Queue
							 insert firt K elements and then for remaining element
							 compare peek element with the current element , if 
							 current element is greater than peek , remove peek 
							 element and insert current element . 
		Time Complexity : O(K) [ To insert first k element or to build heap ] +
											O( N log k) [ To remove and insert into heap .]
											( Inserting heap takes O(log K) ) .
*/

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
class KthLargest 
{

	PriorityQueue<Integer> q ;
	int k ; 

    public KthLargest(int k, int[] nums) 
    {
        this.k = k ; 
        q = new PriorityQueue<>() ;

        for( int i = 0 ; i < nums.length ; i++ )
        		add( nums[i]) ;
    }
    
    public int add(int val) 
    {
        if( q.size() < k )
       		  q.add(val) ;
       	else if( q.peek() < val )
       		 {
       		 	 q.poll() ;
       		 	 q.add(val) ;
       		 }
      return q.peek() ;
    }
}

