/*
        Given a binary tree, you need to compute the length of 
        the diameter of the tree. The diameter of a binary tree 
        is the length of the longest path between any two nodes in a tree. 
        This path may or may not pass through the root.

        Example:
        Given a binary tree  1
                            / \
                           2   3
                          / \     
                         4   5 

                        Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].   

        Here , diameter means sum of left and right subtree . 
        But catch is , to count sum of left and right subtree 
        which node is to be considered as root ? .

        Figure out above question and you will find the solution .
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}