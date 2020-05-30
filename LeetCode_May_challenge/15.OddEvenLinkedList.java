/*
	Given a singly linked list, group all odd nodes together
	followed by the even nodes. Please note here we are talking 
	about the node number and not the value in the nodes.

	You should try to do it in place. The program should run in
	O(1) space complexity and O(nodes) time complexity.

	Example 1:
	Input: 1->2->3->4->5->NULL
	Output: 1->3->5->2->4->NULL

	Example 2:
	Input: 2->1->3->5->6->4->7->NULL
	Output: 2->3->6->7->1->5->4->NULL
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if( head == null )
        	return null ;

    	if( head.next == null || head.next.next == null )
    		return head ;

    	int counter = 1 ;
    	ListNode pointer  = head ;
    	ListNode temp ,rear  ;

    	while( pointer.next != null )
    	{
    		pointer = pointer.next ;
    		counter++ ;
    	}
    
    	/*
    		Placing the rear pointer at the end of the list .
    	*/
    	rear = pointer ;

    	/*
    		The pointer again points to head as it 
    		needs to travese the whole list .
    	*/
    	pointer = head ;

    	int i = 1 ; 
    	while( i < counter )
    	{
    		if( i % 2 != 0 )
    		{
    			temp = pointer.next ;
    			pointer.next = temp.next ;
    			temp.next = null ;
    			rear.next = temp ;
    			rear = temp; 
    			i++ ;
    		}
    		pointer = pointer.next ;
    		i++ ;
    	}

    	return head ;

    }
}