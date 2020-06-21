/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) 
    {
    		if( head == null ) return head ;
    		Node p = head ;

     		while( p.next != null )
     		{
	     			if( p.child != null )
	     			{
	     					Node nextLink = p.next ;
	     					Node temp = flatten( p.child ) ;
	     					temp.prev = p ;
	     					p.next = temp ;

	     					while( p.next != null )
	     					 				p = p.next ;

	     					p.next = nextLink ;
	     					nextLink.prev = p ;
	     			}
	     			p = p.next ;
     		}
     	return head ;   
    }
}