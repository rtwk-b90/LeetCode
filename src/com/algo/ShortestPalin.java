package com.algo;

import java.util.ArrayList;

public class ShortestPalin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(shortestPalindrome("abcd"));
	}
public static String shortestPalindrome(String s) {
        
        ArrayList<Character> arr = new ArrayList();
        for(int i=0;i<s.length();i++){
            arr.add(s.charAt(i));
        }
        int i=0;
        int j=arr.size()-1;
        while(i<j){
           System.out.println(arr.get(i));
            if(arr.get(i)!=arr.get(j)){
                if(i==0)
                     arr.add(0,arr.get(j));
                else{
                    arr.add(i-1,arr.get(j));
                   
                }
                i=0;
                j=arr.size()-1;
            }else{
                i++;
                j--;
            }
        }
        StringBuilder str= new StringBuilder();
        for(char ch: arr){
            str.append(ch);
        }
        return str.toString();
        
    }

}
