/*
	This is the main function to reverse the doubly LinkedList.
	To run this code : Paste this function in GFG .

	Solution : In this instead of looking at the node 
			   and going further and then while returning, 
			   computation is not done .
			   Here computation is done at the time of traversal only .
*/


static Node Reverse( Node start ) 
{ 
  	if( start == null )
      		return start ;
  
  	Node temp    = start.next ;
  	start.next   = start.prev ;
  	start.prev   = temp ;
  
  	/* 
  	   When this condition is hit that 
  		 means the List is reversed .
  	*/
  	if( start.prev == null )
      		return start ;
  
  	return Reverse( start.prev ) ;	 
}

