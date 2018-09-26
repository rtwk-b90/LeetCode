package com.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/****
 * Question asked in Bloomberg challenge
 * Find the characters which are at maximum depth
 * 
 * 
 * 
 * 
 * *******/
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr;
		Solution sol = new Solution();
		 arr=sol.getResult("zg[a{b(cg)d}e{(mn)}]");
		
		
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
		
		
		
	}
	
	ArrayList<String> getResult(String s){
		ArrayList<Point> arr = new ArrayList();
		Stack<Character> st= new Stack();
		int level=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[') {
				
				st.push(s.charAt(i));
				level++;
			}else if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']') {
				StringBuffer br = new StringBuffer();
				char ch=st.pop();
				br.append(ch);
				
				
					while(!st.isEmpty() && st.peek()!='('&& st.peek()!='{'&& st.peek()!='[') {
						
						br.append(st.pop());
					}
					
			
				br=br.reverse();
				
				arr.add(new Point(br.toString(),level));
				if(!st.isEmpty())
					st.pop();
				level--;
				
				
			}else {
				
				st.push(s.charAt(i));
			}
		}
		
		
		Collections.sort(arr,(a,b)-> Integer.compare(b.level,a.level));
		
		
		
		
		
		ArrayList<String> result= new ArrayList();
		
			
		int max=arr.get(0).level;
		for(int i=0;i<arr.size();i++) {
			
			if(arr.get(i).level==max) {
			
				result.add(arr.get(i).s);
			}
		}
		return result;
	}
	

}
class Point{
	
	String s;
	int level;
	Point(String s, int level){
		this.level=level;
		this.s=s;
	}
}