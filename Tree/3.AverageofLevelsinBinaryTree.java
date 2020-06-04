/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
      
     ArrayList<Double> answer = new ArrayList<Double> () ;
      
     if( root == null ) return answer ;
        
     Queue<TreeNode> visited = new LinkedList<TreeNode>() ;
      
     visited.offer( root ) ;
     
     double sum ;
     int size ;
      
     while( !visited.isEmpty() )
     {
       size = visited.size() ;
       sum  = 0 ;
       
       for( int i = 0 ; i < size ; i++ )
       {
         TreeNode currNode = visited.poll() ;
         sum = sum + currNode.val ;
         
         if( currNode.left != null )
              visited.offer( currNode.left ) ;
      
         if( currNode.right != null )
              visited.offer( currNode.right ) ;
       }   
       
       double average = sum / size ;
       answer.add( average ) ;   
     }
     
      return answer ;
      
    }
}