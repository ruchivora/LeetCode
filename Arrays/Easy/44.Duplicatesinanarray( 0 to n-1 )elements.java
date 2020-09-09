/*
		Given an array a[] of size N which contains 
		elements from 0 to N-1. You need to find all 
		the elements occurring more than once in the 
		given array.

		Solution : Tricky Question . 
							 Here we have elements from 0 to n-1 and arrayIndex as 0 to n-1 .
							 So , the array Index is used as a Hash .

		Reference : https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/
							: https://www.youtube.com/watch?v=iiYc32-4ZJY&ab_channel=UBlog 

*/

// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) 
    {
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        
        for( int i = 0 ; i < n ; i++ )
              arr[ arr[i] % n ] += n ;
        
        for( int i = 0 ; i < n ; i++ )
        {
            if( arr[i] / n > 1 ) 
                    list.add( i ) ;
        }
        
        if( list.isEmpty() )
                list.add( -1 ) ;
        
        return list ; 
    }
}
