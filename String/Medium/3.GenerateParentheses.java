
class Solution 
{
	List<String> combination = new ArrayList<String>() ;

  public List<String> generateParenthesis(int n) 
  {
      genearteCombination( 0 , 0 , "" ,n ) ;
    return combination;
  }

  public void genearteCombination( int openBrace , int closeBrace , String s , int max )
  {

  	if( s.length() == 2 * max )
  	{
  		combination.add( s ) ;
  		return  ;
  	}

  	if( openBrace < max ) /* can add open braces */
  					genearteCombination( openBrace + 1 , closeBrace , s + "(" , max ) ;

  	if( closeBrace < openBrace )
  						genearteCombination( openBrace , closeBrace + 1 , s + ")", max ) ;
  }
}