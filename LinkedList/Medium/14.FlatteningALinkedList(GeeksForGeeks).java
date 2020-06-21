/*
    For Question refer : https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
    Very important and good question .

    Solution : Method Flattening : Converts the linkedlist into flat list .
               Method MergeSort and Merge is used to sort the LinkedList .
*/

class GfG
{
    Node flatten(Node root)
    {
       if( root == null || root.next == null )
            return root ;
            
       Node head = flattening( root );
      
      return mergeSort( head ) ;
    }

    public Node flattening( Node root )
    {
        Node p = root ;
        
        while( p != null )
        {
            Node next = p.next ;
            
            while( p.bottom != null )
                    p = p.bottom ; 

            p.bottom = next ;
            p.next   = next ; 
            p        = p.bottom ;
        }
        return root ;
    }

    public Node mergeSort( Node head )
    {
        if( head == null || head.bottom == null )
          return head ;

        Node prev = null ;
        Node slow = head ;
        Node fast = head ;

        while( fast != null && fast.bottom != null )
        {
          prev = slow ;
          slow = slow.bottom ;
          fast = fast.bottom.bottom ;
        }
        prev.bottom = null ;

        Node left  = mergeSort( head ) ;
        Node right = mergeSort( slow ) ;

        return Merge( left , right ) ;
    }

    public Node Merge( Node left , Node right )
    {
      if( left  == null ) return right ;
      if( right == null ) return left ;

      Node p = left ;
      Node q = right ;
      Node r = null ;
      Node dummyHead = new dummyHead(-1) ;
      r   = dummyHead ;

      while( p != null && q != null )
      {
          if( p.data < q.data )
          {
            r.bottom = p ;
            p = p.bottom ;
          }
          else
          {
            r.bottom = q ;
            q = q.bottom ;
          }
          r = r.bottom ;
      }
      if( p == null ) r.bottom = q ;
      if( q == null ) r.bottom = p ;

      return dummyHead.bottom ;
    } 
}