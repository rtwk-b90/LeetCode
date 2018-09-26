package com.algo;

public class Sudoku {

	static int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
	public static void main(String[] arg) {

		
		Sudoku sudoku = new Sudoku();
		sudoku.solveSudoku(grid);
	}

	void solveSudoku(int[][] grid) {

		// TODO Auto-generated method stub
		if(solve(grid,0,0)) {
			
			print(grid);
			return;
		}
		print(grid);;
		return;
			
	}

	private void print(int[][] grid) {
		// TODO Auto-generated method stub
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

	boolean solve(int[][] grid,int row,int col) {
		
		 
		if(!unassignedCell(grid,row,col)) {
			return false;
		}
			
			System.out.println("Cell is unassigned");
			for(int num=0;num<9;num++) {
				
				if(isSafe(grid,row,col,num)) {
					System.out.println();
					grid[row][col]=num;
					
					if (solve(grid,row+1,col))
						return true;
					
					grid[row][col]=0;
				}
				
			}
			return false;
			
		
		
		

	}

	private boolean isSafe(int[][] grid, int row, int col, int num) {
		// TODO Auto-generated method stub
		
		
		return inRow(grid,row,col,num)&& inCol(grid,row,col,num) && inBox(grid,row-row%3,col-col%3,num);
	}

	private boolean inBox(int[][] grid, int row, int col, int num) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				if(grid[row+i][col+j] ==num )return false;
					
			}
		}
		return true;
	}

	private boolean inCol(int[][] grid, int row, int col, int num) {
		// TODO Auto-generated method stub
		for(int i=0;i<grid.length;i++) {
			if(grid[i][col]==num)
				return false;
		}
		return true;
	}

	private boolean inRow(int[][] grid, int row, int col, int num) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<grid[0].length;i++) {
			if(grid[row][i]==num)
				return false;
		}
		return true;
	}

	private boolean unassignedCell(int[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		for( row=0;row<grid.length;row++) {
			for(col=0;col<grid[0].length;col++ ) {
				if(grid[row][col]==0 && row>=0 && col>=0 && row<grid.length && col<=grid[0].length) {
					return true;
				}
			}
		}
		
		
		return false;
	}

}
