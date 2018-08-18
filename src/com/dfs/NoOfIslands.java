package com.dfs;

public class NoOfIslands {

	/*https://leetcode.com/problems/number-of-islands/description/
*/	

    public int numIslands(char[][] grid) {
        int count=0;
        for (int row=0;row<grid.length;row++){
            for(int column=0;column<grid[row].length;column++){
                
                if(grid[row][column]=='1'){
                    
                    isIslands(grid,row,column);
                        ++count;
                    System.out.println(count);
                }
            }
        }
        return count;
    }
    
    void isIslands(char[][] grid,int row,int column){
       
        if (row<0 || column<0 || row>=grid.length || column >=grid[row].length){
            return ;
        }
        if(grid[row][column]=='0')
            return ;
        grid[row][column]='0';
        
         isIslands(grid, row + 1, column);
    isIslands(grid, row - 1, column);
    isIslands(grid, row, column + 1);
    isIslands(grid, row, column - 1);
        
    }
}
