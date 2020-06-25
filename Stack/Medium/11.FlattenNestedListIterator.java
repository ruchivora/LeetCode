/*
		Here we don't prefer to use stack because stack is not suitable .
		We use Queue . 
		Different Question ( heavy on OOPS ) .

*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> 
{
	  Queue<Integer> q ;

    public NestedIterator( List<NestedInteger> nestedList ) 
    {
        q = new LinkedList<Integer>() ;
        addAll(nestedList) ;
    }

    public void addAll( List<NestedInteger> nestedList )
    {
    		for( NestedInteger ni : nestedList )
    		{
    			if( ni.isInteger())
    				q.offer( ni.getInteger() ) ;
    			else
    					addAll( ni.getList() ) ;
    		}
    }

    public Integer next() 
    {
        return !q.isEmpty() ? q.poll() : -1;
    }

    public boolean hasNext() 
    {
        return !q.isEmpty() ;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */