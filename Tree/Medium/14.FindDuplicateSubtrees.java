/*
		My doubt was( very silly ) : How to add node { {4} , {2,4} } 
		But here you need not add TreeNode.val but instead we have to 
		add TreeNode . So if we add TreeNode for 2 then TreeNode for 4
		will also be added .

		At each step we append past string i.e serial .

		Reference( for understanding ) : https://www.youtube.com/watch?v=nxHBg7hm0rs 

		Code : https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution

*/

class Solution {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) 
  {
  		List<TreeNode> result = new LinkedList<>() ;
  		HashMap<String,Integer> map = new HashMap<String,Integer>() ; 
  		postOrder( root , map , result ) ;

  		System.out.println( Arrays.asList( map ) ) ;

    return result ;   
  }

  public String postOrder( TreeNode curr , HashMap<String,Integer> map , List<TreeNode> result)
  {
	  	if( curr == null )
	  				return "#" ;

	  	String serial = curr.val + "," + postOrder( curr.left , map , result ) + "," + postOrder( curr.right , map , result ) ;
	  	
	  	if( map.containsKey( serial ) )
	  	{
	  		/* 
	  				Why do we add an element to the list only when the count is 1 ?  
	  				 - Because if a node with value 4 occurs multiple times
	  				   then we have to add it to the list only once . 
	  		*/
	  		if( map.get(serial) == 1 ) 
	  					result.add( curr ) ;
	  	}

	  	map.put( serial , map.getOrDefault( serial , 0 ) + 1 ) ; 

	  return serial ;
  }


}