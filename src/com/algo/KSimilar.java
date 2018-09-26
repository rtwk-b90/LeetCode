package com.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KSimilar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSimilar ks= new KSimilar();
		System.out.println(ks.kSimilarity("abcbca","ababcc"));
		System.out.println("########");
		//System.out.println(ks.kSimilarity_bkp("aaabc","abcaa"));
	}
	
	public int kSimilarity(String A, String B) {
        Queue<String> queue = new ArrayDeque();
        queue.offer(A);

        Map<String, Integer> dist = new HashMap();
        dist.put(A, 0);

        while (!queue.isEmpty()) {
            String S = queue.poll();
            if (S.equals(B)) return dist.get(S);
            for (String T: neighbors(S, B)) {
                if (!dist.containsKey(T)) {
                    dist.put(T, dist.get(S) + 1);
                    queue.offer(T);
                }
            }
        }

        throw null;
    }

    public List<String> neighbors(String S, String target) {
        List<String> ans = new ArrayList();
        int i = 0;
        for (; i < S.length(); ++i) {
            if (S.charAt(i) != target.charAt(i)) break;
        }

        char[] T = S.toCharArray();
        for (int j = i+1; j < S.length(); ++j)
            if (S.charAt(j) == target.charAt(i)) {
                swap(T, i, j);
                ans.add(new String(T));
                swap(T, i, j);
            }

        return ans;
    }

    public void swap(char[] T, int i, int j) {
        char tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }
    
    
    
    
public int kSimilarity_bkp(String A, String B) {
        
        if(A.length()!=B.length())
            return -1;
       char[] arrayA=A.toCharArray();
        char[] arrayB=B.toCharArray();
        int count=0;
        for(int i=0;i<arrayA.length;i++){
            
            if(arrayA[i]!=arrayB[i]){
                
                int index=B.indexOf(arrayA[i],i);
                
                System.out.println(arrayA[i]+" "+index+" i="+i);
                //swap
                char tmp;
                tmp=arrayB[index];
                arrayB[index]=arrayB[i];
                arrayB[i]=tmp;
                count++;
                System.out.println(arrayB);
                System.out.println("Count="+count);
                B=String.valueOf(arrayB);
            }
        }
        return count;
        
    }

}
