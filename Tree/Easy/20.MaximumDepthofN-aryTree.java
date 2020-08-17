/*
    Contains both DFS And BFS of n-ary tree .
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/*
    DFS pf n-ary tree .
*/
class Solution {

    int maxdepth = 0 ;

    public int maxDepth(Node root) 
    {

      if( root == null ) return 0 ;
      getDepth( root , 1 ) ;
        
      return maxdepth ;
    }

    public void getDepth( Node root , int depth )
    {
        if( root == null )
        return ;

        maxdepth = Math.max( maxdepth , depth ) ;

        for( int i = 0 ; i < root.children.size() ; i++ )
            getDepth( root.children.get(i) , depth + 1 ) ;
    }
}
