/*
	Given two strings S and T, return if they are equal when both 
	are typed into empty text editors. # means a backspace character.

	Example 1:

	Input: S = "ab#c", T = "ad#c"
	Output: true
	Explanation: Both S and T become "ac".

	Example 2:
	Input: S = "ab##", T = "c#d#"
	Output: true
	Explanation: Both S and T become "".

	Example 3:
	Input: S = "a##c", T = "#a#c"
	Output: true
	Explanation: Both S and T become "c".
*/



class Solution {
    public boolean backspaceCompare(String S, String T) {
        int S_pointer = S.length()-1 ;
        int T_pointer = T.length()-1 ;

        int S_skip = 0 ;
        int T_skip = 0 ;

        while( S_pointer >= 0 || T_pointer >= 0) 
              {
                  while( S_pointer >= 0 )
                  {
	                    if( S.charAt(S_pointer) == '#' )
	                    {
	                      S_skip    +=1 ;
	                      S_pointer -=1 ;
	                    }else if(S_skip > 0 )
	                            {
	                              S_skip    -= 1 ;
	                              S_pointer -= 1 ;
	                             }
	                            else{
	                              break ;
	                            }     
                  }
                
                while( T_pointer >= 0 )
                {
	                  if( T.charAt(T_pointer) == '#' )
	                  {
	                    T_skip    +=  1 ;
	                    T_pointer -=  1 ;
	                  }else if( T_skip > 0)
	                          {
	                            T_skip    -= 1 ;
	                            T_pointer -= 1 ;
	                          }
	                          else{
	                            break ;
	                          }         
                }

                if( T_pointer >= 0 && S_pointer >=0 &&  T.charAt(T_pointer) != S.charAt(S_pointer)  )
                  return false ;
    
                if( (S_pointer >= 0) != (T_pointer >= 0)   )
                    return false ;

                S_pointer -= 1 ;
                T_pointer -= 1 ;
              }                
     	return true ;             
    }
}