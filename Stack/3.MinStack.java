/*
    Mystake : If the satck contains duplicate values . 
              if( stack1.isEmpty() || minStack.peek() >= x )
              Then it should be >= and not just > .
*/

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack1   = new Stack<Integer>() ;
    Stack<Integer> minStack = new Stack<Integer>() ;
    
    public void push(int x) 
    {
       if( stack1.isEmpty() || minStack.peek() >= x )
            minStack.push(x) ;
        stack1.push(x) ;  
    }
    
    public void pop() 
    {
      if( !stack1.isEmpty() )
      {
        int x = stack1.pop() ;
        if( x == minStack.peek() )
            minStack.pop() ;
      }
    }
    
    public int top() 
    {
      return stack1.peek() ;
    }
    
    public int getMin() 
    {
      return minStack.peek() ;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */