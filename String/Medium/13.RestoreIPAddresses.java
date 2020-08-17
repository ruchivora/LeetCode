/*
		The problem uses DFS + Backtracking

		First we understand that the correct IP is:

		1. 4 numbers seperated by 3 "."
		2. each number cannot begin with 0, except being 0 itself
		3. each number must be less than or equal to 255
		4. in our case, the IP must use up all the numbers in "s", sequentially
		
		Now let's look at the algorithm. For each entry between the ".", 
		we can either choose to use single digit, two digits, or three digits. 
		We basically go through the entire input string "s". With the rules we 
		stated above, we add checks to see whether the cases of using one, two, 
		or three (or all) digtis are applicable at the any given place in "s". 
		If any cases are applicable, we add it to the stringbuilder, go to the 
		next place in "s", then backtrack by removing what we added from stringbuilder.

		Reference Code : https://leetcode.com/problems/restore-ip-addresses/discuss/310798/Java-Easy-to-Read-Recursive(Backtracking)-Solution-Explained
		Reference Video ( To understand the concept ) : https://www.youtube.com/watch?v=czvZyhZaHz0

		Also the problem "  Split Array into Fibonacci Sequence " uses " DFS + Backtracking"
		Reference Link : https://leetcode.com/problems/split-array-into-fibonacci-sequence/
*/


class Solution 
{
  public List<String> restoreIpAddresses(String s) 
  {
     List<String> result = new ArrayList<String>() ;
     
     if( s.length() > 12 || s.length() < 4 ) return result ;

     findAddress( s , result , new StringBuilder() , 0 , 0 ) ;
     return result ;
  }
  public void findAddress( String s , List<String> result , StringBuilder curr , int i , int count )
  {
	  	if( count > 4 ) return ; 

	  	if( count == 4 && i == s.length() )
	  	{
	  		result.add( curr.toString().substring( 0 , curr.length() - 1 ) ) ;
	  		return ;
	  	}

	  	// Use 1 digit 

	  	if( i < s.length() )
	  	{
	  		curr.append( s.substring( i , i + 1 ) + "." ) ;
	  		findAddress( s , result , curr , i + 1 , count + 1 ) ;
	  		curr.delete( curr.length() - 2 , curr.length() ) ; //curr.length() - 2 because , we have also added "." 
	  	}

	  	// use 2 digit

	  	if( i + 1  < s.length() && s.charAt(i) != '0' )
	  	{
	  		curr.append( s.substring( i , i + 2 ) + "." ) ;
	  		findAddress( s , result , curr , i + 2 , count + 1 ) ;
	  		curr.delete( curr.length() - 3 , curr.length() ) ; 
	  	}

	  	// Use 3 digit 

	  	if( i + 2 < s.length() && s.charAt( i ) != '0' && Integer.parseInt( s.substring( i , i + 3 )) <= 255 )
	  	{
	  		curr.append( s.substring( i , i + 3 ) + "." ) ;
	  		findAddress( s , result , curr , i + 3 , count + 1 ) ;
	  		curr.delete( curr.length() - 4 , curr.length() ) ;
	  	}
  }
}