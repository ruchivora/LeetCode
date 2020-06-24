class MyQueue {

    Stack<Integer> stack1 = new Stack<Integer>() ;
    Stack<Integer> stack2 = new Stack<Integer>() ;
    int peekEle = -1 ; 
    
    /** Push element x to the back of queue. */
    public void push(int x) 
    {
        if( stack1.isEmpty() )
              peekEle = x ;
        stack1.add( x ) ;    
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() 
    {
       while( !stack1.isEmpty() )
                stack2.add( stack1.pop() ) ;
        
       int popEle = stack2.pop() ;

       if( !stack2.isEmpty() )
            peekEle = stack2.peek() ;

       while( !stack2.isEmpty() )
                stack1.push( stack2.pop() ) ;
       
      return popEle ;
    }
    
    /** Get the front element. */
    public int peek() 
    {
        return peekEle ;    
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() 
    {
        return stack1.isEmpty() ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */