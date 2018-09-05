package com.algo;

import java.util.LinkedList;
import java.util.Queue;

public class RateInMaze {

	public static void main(String args[]) {
		RateInMaze rat = new RateInMaze();
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		rat.solveMazeBackTracking(maze);
		System.out.println(countBack);
		rat.solveMazeDFS(maze);
		System.out.println(countDFS);
		rat.solveMazeBFS(maze);
		System.out.println(countBFS);
	}

	
	static int countBFS=0;
	private void solveMazeBFS(int[][] maze) {
		// TODO Auto-generated method stub

		countBFS=solveBFS(maze,0,0,0);
	}
	int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

	private int solveBFS(int[][] maze,int sr, int sc, int sum) {
		// TODO Auto-generated method stub
		
		Queue<int[]> que= new LinkedList();
		que.add(new int[] {sr,sc,sum});
		boolean[][] seen = new boolean[maze.length][maze[0].length];
	    seen[sr][sc] = true;
		
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			for(int i=0;i<4;i++) {
				int r=cur[0]+dr[i];
				int c= cur[1]+dc[i];
				
				
				if(isSafe(maze,r,c) && seen[r][c]==false) {
					seen[r][c]=true;
					que.add(new int[] {r,c,sum++});
				}
			}
			
		}
		return sum;
	}

/**
 * DFS
 * @param maze
 */
	static int countDFS=0;
	private void solveMazeDFS(int[][] maze) {
		// TODO Auto-generated method stub

		int count=0;
		boolean[][] seen= new boolean[maze.length][maze[0].length]; 
		
				
				if(maze[0][0]==1) {
					
					solveDFS(maze,0,0,seen);
					count++;
				}
			
		
		//countDFS=count;
	}

	private void solveDFS(int[][] maze, int i, int j,boolean[][] seen) {
	// TODO Auto-generated method stub
		
		System.out.println("DFS="+i+"col="+j);
		if(i<0 || j<0 || i>=maze.length || j>=maze[0].length || seen[i][j]) {
		
			return ;
		}
		if(maze[i][j]==0) {
			
			return;
		}
			
		
		seen[i][j]=true;
		countDFS++;
		
		solveDFS(maze,i+1,j,seen);
		//solveDFS(maze,i-1,j,seen);
		solveDFS(maze,i,j+1,seen);
		//solveDFS(maze,i,j-1,seen);
		
	
}

	/*******
	 * backtracking...
	 * @param maze
	 */
	private void solveMazeBackTracking(int[][] maze) {
		// TODO Auto-generated method stub
		int[][] sol = new int[maze.length][maze[0].length];
		if (solveBack(maze, 0, 0, sol)) {

		}

	}

	static int countBack=0;
	private boolean solveBack(int[][] maze, int row, int col, int[][] sol) {
		// TODO Auto-generated method stub

		if(row==maze.length-1 && col==maze[0].length-1)
			return true;
		
		if (isSafe(maze, row, col)) {
			sol[row][col] = 1;
			countBack++;

			if (solveBack(maze, row, col + 1, sol))
				return true;

			if (solveBack(maze, row + 1, col, sol))
				return true;

			sol[row][col] = 0;
			countBack--;

		}
		return false;

	}

	private boolean isSafe(int[][] maze, int row, int col) {
		// TODO Auto-generated method stub
		
		if(row<=maze.length-1 && col<=maze[0].length-1 && row>=0 && col>=0 && maze[row][col] == 1)
			return true;
		return false;
	}

}
