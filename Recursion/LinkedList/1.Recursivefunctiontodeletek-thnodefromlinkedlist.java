/*
		The solution is compiled on GFG . 
		Question : https://www.geeksforgeeks.org/recursive-function-delete-k-th-node-linked-list/
*/
class DeleteKthNode
{ 
	static class Node 
	{ 
		int data; 
		Node next; 
	}; 

	static Node deleteNode( Node start , int k ) 
	{ 
		/*
				This condition will only hit if k is 
				invalid at the start .
		*/
		if( k < 1 ) 
				return start ; 

		/*
				This condition will only hit if the 
				List is empty at start .
		*/
		if( start == null ) 
				return null ; 

		if( k == 1 ) 
		{ 
			Node res = start.next ; 
				return res ; 
		} 
		
		start.next = deleteNode( start.next , k - 1 ) ; 
			return start ; 

	} 


	static Node push( Node head_ref, int new_data) 
	{ 
		Node new_node = new Node(); 
		new_node.data = new_data; 
		new_node.next = head_ref; 
		head_ref = new_node; 
		return head_ref; 
	} 


	static void printList( Node head) 
	{ 
		while (head!=null) 
		{ 
			System.out.print(head.data + " "); 
			head = head.next; 
		} 
		System.out.printf("\n"); 
	} 


	public static void main(String args[]) 
	{ 
		Node head = null; 

		head=push(head,3); 
		head=push(head,2); 
		head=push(head,6); 
		head=push(head,5); 
		head=push(head,11); 
		head=push(head,10); 
		head=push(head,15); 
		head=push(head,12); 
		
		int k = 3; 
		head = deleteNode(head, k); 

		System.out.printf("\nModified Linked List: "); 
		printList(head); 
	} 

} 
	