package com.algo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> wordDict= new HashSet();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		String s="catsanddog";
		System.out.println(wordBreak(s,wordDict));

	}
	
	
	    public static List<String> wordBreak(String s, Set<String> wordDict) {
	        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
	        LinkedList<String> initial = new LinkedList<>();
	        initial.add("");
	        dp[0] = initial;
	        for (int i = 1; i <= s.length(); i++) {
	            LinkedList<String> list = new LinkedList<>();
	            for (int j = 0; j < i; j++) {
	                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
	                    for (String l : dp[j]) {
	                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
	                    }
	                }
	            }
	            dp[i] = list;
	        }
	        return dp[s.length()];
	    }
	

}
