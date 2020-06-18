/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

*/

 /*
    Solution 1 : Using HashMap 
 */


class Solution {
    public Node copyRandomList(Node head) 
    {

    }
}






/*
    Most efficient algorithm but not accepted by LeetCode
    Because of "Next pointer of node with label 7 from the 
    original list was modified." i.e They don't want 
    to modify original linkedlist .

    Reference : https://www.youtube.com/watch?v=xbpUHSKoALg&t=281s
*/

class Solution {
    public Node copyRandomList(Node head) 
    {
        Node curr = head ;
        Node prev = null ;
        Node next = null ;
        
        /*
            Inserts duplicate node in the list .
        */
        while( curr != null )
        {
          next = curr.next ;
          Node temp = new Node( curr.val );
          temp.next = curr.next ;
          curr.next = temp ;
          curr = next ;
        }

        /*
            Assigning random pointer to the duplicate nodes
            inserted before .
        */
        curr = head ;
        int count = 1 ;

        while( curr != null )
        {
            if( count % 2 == 0 )
            {
              /* condition encountered when 7's random pointer points to null*/
              if( prev.random == null ) 
                  curr.random  = null ;
              else curr.random = prev.random.next ;
            }
            prev = curr ;
            curr = curr.next ; 
            count++ ;
        }

        /*
            Removing the initial nodes from the Linked List .
        */

        head = head.next ;
        curr = head ;

        while( curr.next != null )
        {
          curr.next = curr.next.next ;
          curr = curr.next ;
        }

        return head ;
    }
}