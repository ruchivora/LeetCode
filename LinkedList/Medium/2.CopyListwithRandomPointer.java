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
                 what if the linkedlist 
 */

class Solution {
    public Node copyRandomList(Node head) 
    {
        if(head==null) return null;

        Node curr = new Node(head.val) ; 
        Node temp = head ; 
        Node sol  = curr;
        HashMap<Node,Node>map = new HashMap();
        
        while(head != null)
        {
            curr.next = new Node(head.val);
            if(curr.next!=null) 
                map.put(head,curr.next);
            curr = curr.next;
            head = head.next;
        }
        while(temp != null)
        {
            Node temp2 = map.get(temp);
            if(temp.random != null)
                temp2.random = map.get(temp.random);
            temp = temp.next;
        }
        return sol.next;
    }
}
