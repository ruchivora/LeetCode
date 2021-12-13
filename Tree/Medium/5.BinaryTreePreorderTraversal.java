/*
		Iterative PreOrderTraversal : https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=10&ab_channel=takeUforward

*/
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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> preOrder = new ArrayList<Integer>() ;
        Stack<TreeNode> stack  = new Stack<TreeNode>() ;
        
        if( root ==null )
            return preOrder ;
        
        stack.push( root ) ;
        
        while( !stack.isEmpty() )
        {
            TreeNode currEle = stack.pop() ;

            if( currEle.right != null )
                    stack.push( currEle.right ) ;
            
            if( currEle.left != null )
                    stack.push( currEle.left ) ;
            
            
            preOrder.add( currEle.val ) ;
            
        }
        return preOrder ;  
    }
}
