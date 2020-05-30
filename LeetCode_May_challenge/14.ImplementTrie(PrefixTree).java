/*
    Learnt new type of tree .
    Hint : https://www.youtube.com/watch?v=NscT5CQLeqY
*/
class Trie {

    /* 
        Initialize your data structure here. 
    */

    private Trie children[] ;
    private boolean isEndOfWord ;

    public Trie() {
        children    = new Trie[26] ;
        isEndOfWord = false ; 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this ; 
        for( int  i = 0 ; i < word.length() ; i++ )
        {
            if( curr.children[ word.charAt(i) - 'a'] == null )
                curr.children[word.charAt(i) - 'a'] = new Trie() ;
            curr = curr.children[word.charAt(i) - 'a'] ;
        }
        curr.isEndOfWord = true ;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this ;
        for( int i = 0 ; i < word.length() ; i++ )
        {
            curr = curr.children[word.charAt(i) - 'a'] ;
            if( curr == null )
                return false ; 
        }
        if( curr.isEndOfWord )
            return true ;
        return false ;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        Trie curr = this ;

        for( int i = 0 ; i < prefix.length() ; i++ )
        {
            curr = curr.children[prefix.charAt(i) - 'a'] ;
            if( curr == null )
                return false ; 
        }
        return true ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */