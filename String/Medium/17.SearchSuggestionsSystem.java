/*
		New Concept !

			What is Trie ? And how does it help in recommandation or AutoComplete System ?
			 - Reference : https://www.youtube.com/watch?v=DfkLGiW8vNA 

			We can use a special kind of trie for this problem. 
			Instead of keeping words in the bottom (last) node for 
			each word we do the other way around - keep word in every 
			node starting from the first character. This way we can 
			immidiately get all words for the current character without 
			traversing the trie. This way we're making a trade off memory 
			(each trie node keep up to three words) for performance.

			For the sorted result we do following optimizations -
			we sort the ditionary before we start, this way all 
			words will be added to the trie in a sorted order. 
			Then in every node we can fill the word's list in a 
			greedy manner - once we've filled 3 elements of the list 
			skip every next word. This way we can just add all the 
			list from each trie node to result.

			Code Reference : https://leetcode.com/problems/search-suggestions-system/discuss/440474/Java-trie-explained-clean-code-14ms 
*/

class Solution 
{
  public List<List<String>> suggestedProducts(String[] products, String searchWord) 
  {
  		/*
  			Elements of the Products are sorted in lexicographic Order .
  			eg : ["mobile","mouse","moneypot","monitor","mousepad"]
  			Result : [mobile, moneypot, monitor, mouse, mousepad]
  		*/

      Arrays.sort( products ) ;

      Trie root = new Trie() ;

      for( int i = 0 ; i < products.length ; i++ )
      {
	      	Trie n = root ;
	      	/* Convert Product String to Char Array . */
	      	char ch[] = products[i].toCharArray() ;

	      	for( int j = 0 ; j < ch.length ; j++ )
	      	{
	      		int k = ch[j] - 'a' ;

	      		/* Creats Pointer for a particular Character */

	      		if( n.next[k] == null )
	      					n.next[k] = new Trie() ;

	      		n = n.next[k] ;

	      		/* 
			      			 Appends words( from Product Array ) at every node . Number of 
									 such words to be added is 3 .
							
										Consider example : [mobile, moneypot, monitor, mouse, mousepad]

												/(root)
										/				\
								char 'm'
								<mobile , moneypot , monitor>
								/
							char 'o'
							< mobile , moneypot ,monitor >
							/            \
							char 'b'     char 'n'
							<mobile>      <moneypot , monitor>
								.              \           \
							  .						  char 'e'     char 'i'
							 							  <moneypot>    <monitor>
							  .									.           .
							  .                 .           .
							  .                 .           .
			
							In this way a Trie is Constructed . In this problem
						
	      		*/

	      		if( n.words.size() < 3 )
	      					n.words.add( products[i] ) ;
	      	}
      }

      /* 
      		Now as and when the characters are enetered the corrsp 
      		strings are displayed !. 
      */

      List<List<String>> res = new ArrayList() ;
      Trie n = root ;

      for( int i = 0 ; i < searchWord.length() ; i++ )
      {
	      	n = n.next[ searchWord.charAt(i) - 'a' ] ;
	      	if( n == null )
	      	{
	      		  for( int j = i ; j < searchWord.length() ; j++ )
	      		 				res.add( Collections.EMPTY_LIST ) ;
	      		  break ;
	      	}
	      res.add( n.words ) ;
      }
    return res ;
  }
}

class Trie{

	Trie[] next ; 
	List<String> words ;
	Trie()
	{
		words = new ArrayList() ;
		next  = new Trie[26] ;
	}

}