package com.facebook;

/***
 * This was asked me during Facebook interview second round.
 * Ques: Given two strings s and words, assume s is order.
 *  I need to check if the chars are present in the word list according to the oder they 
 *  appear in string s.
 * My solution is taking O(MXN) , I used DP. and this was accepted in Facebook round.
 * 
 * *****/


public class OrderFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {
				"e",
				"q",
				"a",
				"c",
				"b"
		};
		
		String word[]= {
				"eqa",
				"qzx",
				"axz",
				"cs",
				"bs"
		};
		System.out.println(isCorrectOrder(s,word));
		
	}
	
	static boolean isCorrectOrder(String[] s, String[] words){
		
		boolean[][] matrix= new boolean[s.length+1][words.length+1];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<s.length;i++) {
			int count=0;
			for(int j=0;j<words.length;j++) {
				
				if(words[j].contains(s[i])) {
					matrix[i+1][j+1]=true;
				}else {
					matrix[i+1][j+1]=matrix[i+1][j];
				}
				if(matrix[i+1][j+1]==true)
					count++;
			}
			if(i==0) {
				max=count;
			}else if(max<count)
				return false;
		}
		
		return true;
		
		
	}

}
