/*
    Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: 
    Starting with any positive integer, replace the number by the 
    sum of the squares of its digits, and repeat the process until
    the number equals 1 (where it will stay), or it loops endlessly 
    in a cycle which does not include 1. 
    Those numbers for which this process ends in 1 are happy numbers.

  Input: 19
  Output: true
  Explanation: 
  12 + 92 = 82
  82 + 22 = 68
  62 + 82 = 100
  12 + 02 + 02 = 1

*/

class Happy_number {
    public boolean isHappy(int num) {
    
      HashSet<Integer> num_count  =  new HashSet<Integer>() ;

    while( num != 1 )
    {
      int sum = 0;
        while( num != 0 )
        {
          int digit = num%10 ; 
          sum  += digit*digit ;
          num = num/10 ;
        }
      if(num_count.contains(sum))
         return false ;
      else num_count.add(sum) ;
      
        num = sum ;
    }
     return true ;         
    }
}