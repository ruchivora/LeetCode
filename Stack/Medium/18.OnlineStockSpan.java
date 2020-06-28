/*
		The span of the stock's price today is defined as the 
		maximum number of consecutive days (starting from today 
		and going backwards) for which the price of the stock 
		was less than or equal to today's price.

		The above statement clearly says : Find nearest
		greatest element to the left . But here we don't 
		have array and So we need to form stack as a
		Pair of elements .
		
		Reference : https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6

*/

class StockSpanner 
{
	Stack<Pair<Integer,Integer>> stack ;

  public StockSpanner() 
  {
    stack = new  Stack() ; 
  }
    
  public int next( int price ) 
  {
  	int span = 1 ;

  	while( !stack.isEmpty() && price >= stack.peek().getKey()  )
  	{
       span += stack.peek().getValue() ;
       stack.pop() ;
  	}
  	stack.push( new Pair( price , span ) ) ;

  	return span ;
  }
}