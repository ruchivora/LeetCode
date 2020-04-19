class MinStack {

    /** initialize your data structure here. */

     Stack<Integer> stack   = new Stack () ;
     Stack<Integer> get_min = new Stack()  ;

    public void push(int x) {
    
      if(get_min.isEmpty() || x <get_min.peek())
      {
          get_min.push(x) ;
      }  
        stack.push(x) ;
    }
    
    public void pop() {

        if( (stack.peek()).equals(get_min.peek()) )
        {
            get_min.pop() ;
        }    
        stack.pop();
    }
    
    public int top() {
        return stack.peek() ;
    }
    
    public int getMin() {
        return get_min.peek();
    }
}