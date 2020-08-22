/*
		Logic : Traverse the Tree and store the elements in a List . 
						Then add those numbers stored in the List . 
						And return the answer . 

		Think ? 
			- Why you need to store the elements in the List ?
					- Because you had to add those elements . 
					- What if you can add those elements on the go . 
					- Then you need not store in the list .

		In case of trees , understand how will the recursion work
		when backtracking will happen ! .
	
*/


class Solution {
	
  public int sumNumbers(TreeNode root) 
  {
      if( root == null )
      		return 0 ;

      ArrayList<String> numList = new ArrayList<String>() ;  
      String num = new String() ; 

      getNum( root , numList , num ) ;

    return calSum( numList ) ; 
  }

  public void getNum( TreeNode root , ArrayList<String> numList , String num )
  {
  		if( root == null )
  				return ; 

  		num = num + root.val  ; 
  		
  		if( root.left == null && root.right == null )
  		{
  			numList.add( num ) ;
  			return ; 
  		}

  		getNum( root.left  , numList , num ) ; 
  		getNum( root.right , numList , num ) ; 

  		num = num.substring( 0 , num.length() - 1 ) ;

  }

  public int calSum( ArrayList<String> numList )
  {
  		int sum = 0 ; 

  		for( int i = 0 ; i < numList.size() ; i++ )
  						sum = sum + Integer.parseInt( numList.get(i) ) ;

  	return sum ;
  }

}


class Solution 
{
  public int sumNumbers(TreeNode root) 
  {
      if( root == null ) 
  	    	return 0 ; 	

  	return sum( root , 0 ) ; 
  }

  public int sum( TreeNode root , int sum )
  {
  		if( root == null )
  				return 0 ; 

  		if( root.left == null && root.right == null )
  						return sum * 10 + root.val ; 

  	return 	sum( root.left , sum*10 + root.val ) + sum( root.right , sum * 10 + root.val ) ; 
  }

}