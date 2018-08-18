package com.dfs;

/*https://leetcode.com/problems/max-area-of-island/description/
*/
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxSize=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j]==1){
                    
                    int size=getSize(grid,i,j);
                    maxSize= Math.max(maxSize,size);
                }
            }
        }
       return maxSize; 
    }
    
    
    int getSize(int[][] grid, int row,int col){
        
        int R=grid.length;
        int C=grid[0].length;
        int size=1;
        if(row<0 || col<0 || row>=R || col>=C){
            
            return 0;
        }
        
        if(grid[row][col]==0)
            return 0;
        
        grid[row][col]=0;
        
        size+=getSize(grid,row-1,col);
        size+=getSize(grid,row+1,col);
        size+=getSize(grid,row,col+1);
        size+=getSize(grid,row,col-1);
        return size;
    }
}
