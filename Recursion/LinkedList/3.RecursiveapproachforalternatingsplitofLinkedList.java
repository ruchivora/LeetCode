 /*
			If we do iterativly , then we need two pointers .
			Similarly , in recursion also we need two pointers
			and then perform recursion on it . 

			Question : https://www.geeksforgeeks.org/recursive-approach-alternating-split-linked-list/

 */
class GFG 
{ 
  	
  static Node a = null, b = null; 
  
	static class Node 
	{ 
		int data; 
		Node next; 
	}; 
  
	public static void main(String args[]) 
	{ 
		Node head = null; 
		head = push(head, 7); 
		head = push(head, 6); 
		head = push(head, 5); 
		head = push(head, 4); 
		head = push(head, 3); 
		head = push(head, 2); 
		head = push(head, 1); 

		Node a = head ;
		Node b = head.next ;
		
		splitList( a , b ); 

		display(a);
    System.out.println() ; 
		display(b); 
	} 

	static void splitList(Node a, Node b) 
	{ 
		if ( b == null || a == null ) 
			return; 

		if (a.next != null) 
			a.next = a.next.next; 

		if (b.next != null) 
			b.next = b.next.next; 

		splitList(a.next, b.next); 
	} 


	static Node push(Node head, int new_data) 
	{ 
		Node new_node = new Node(); 
		new_node.data = new_data; 
		new_node.next = (head); 
		(head) = new_node; 
		return head; 
	} 


	static void display(Node head) 
	{ 
		Node curr = head; 
		while (curr != null) 
		{ 
			System.out.printf("%d ", curr.data); 
			curr = curr.next; 
		} 
	} 

} 





