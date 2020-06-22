/*
    For Question : refer - https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
    Solution 1 : Count number of occurance of each element
                 Then replace the value according to count .
    Time complexity : O(N) . Two Pass Solution .

    Solution 2 : Make three List head headZero , headOne , headTwo .
                 As you traverse the list append the node .
                 At the end combine all the three lists .
    TimeComplexity : O(N) . One Pass Solution .                 

*/

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class LinkedList
{
    static Node segregate(Node head)
    {
        if( head == null || head.next == null )
              return head ;

        Node p = head ;
        long countZero = 0 ;
        long countOne  = 0 ;
        long countTwo  = 0 ;

        while( p != null )
        {
          if( p.data == 0 ) countZero++;
          if( p.data == 1 ) countOne++ ;
          if( p.data == 2 ) countTwo++ ;
          p = p.next ; 
        }

       p = head ;
       while( p != null )
       {
           if( countZero > 0){
              p.data = 0 ;
              countZero-- ;
           }
           else if( countOne > 0 ){
                  p.data = 1 ;
                  countOne-- ;
                }
                else{
                  p.data = 2 ;
                  countTwo-- ;
                }
          p = p.next ;
       }

        return head ;
    }
}


