class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
    	if( image[sr][sc] == newColor )
    		return image ;

    	floodfill( image , sr , sc , image[sr][sc] , newColor) ;
      	return image ;

    }
    public void floodfill( int[][]image , int sr , int sc , int color , int newColor)
    {
    	if( sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color )
    	{
       		 return ;
   		}
    	image[sr][sc] = newColor ;
    	floodfill( image , sr + 1 , sc , color , newColor) ;
    	floodfill( image , sr - 1 , sc , color , newColor) ;
    	floodfill( image , sr , sc + 1 , color , newColor) ;
    	floodfill( image , sr , sc - 1 , color , newColor) ;
    }
}