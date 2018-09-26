// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(int A, int B) {
        // write your code in Java SE 8
        StringBuffer sbA= new StringBuffer();
        StringBuffer sbB= new StringBuffer();
       for(int j=0;j<A;j++){
           sbA.append("a");
           
       }
       for(int l=0;l<B;l++){
            sbB.append("b");
       }
       String strA=sbA.toString();
       String strB=sbB.toString();
      if(A>B) {
    	  if(A/2 > B)
    		  return null;
      }
      if(B>A) {
    	  if(B/2 > A)
    		  return null;
      }
    	  
        if(A==B){
            System.out.println("A==B");
          return  buildString(strA,strB,2,0);
        }
        else if(A>B){
              System.out.println("A>B");
            return  buildString(strA,strB,2,A-B);
        }
        
        else{
             System.out.println("A<B");
             return  buildString(strB,strA,2,B-A);
        }
        
    }
    
    String buildString(String big, String small,int size, int diff){
        int bSize=2;
        if(diff>=3){
            bSize=1;
        }
        size=1;
        StringBuffer finalString = new StringBuffer();
        for(int i=0;i<big.length();i++){
            
            int count=1;
            while(count<=size){
                count++;
                if(bSize==2){
               finalString.append(big.charAt(i));
               int j=i+1;
               if(j<big.length())
                finalString.append(big.charAt(j));
                
                if(i<small.length())
                finalString.append(small.charAt(i));
                
               if(j<small.length())
                finalString.append(small.charAt(j));
               i=j;
               
            }
            else{
                 finalString.append(big.charAt(i));
               int j=i+1;
               if(j<big.length())
                finalString.append(big.charAt(j));
                 if(i<small.length())
                finalString.append(small.charAt(i));
                 i=j;
            }
            }
           
        }
        
         return finalString.toString();
        
    }
    
    public static void main(String[] v) {
    	
    	Solution o = new Solution();
    	System.out.println(o.solution(5, 3));
    }
}