import java.util.ArrayList;
import java.util.Collections;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// //System.out.println("this is a debug message");

class Solution1 {
    public String solution(int[] T) {
        // write your code in Java SE 8
        
        if(T==null)
        return null;
        if(T.length%4!=0)
        return null;
        String season="";
       
       
        int size=T.length/4;
       
        int count=1;
        int max=Integer.MIN_VALUE;
        int i=0;
            while( i<=T.length-size){
            	
             ArrayList<Integer> arr = new ArrayList();
            for(int j=i;j<i+size;j++){
                
                arr.add(T[j]);
            }
            i=i+size;
            Collections.sort(arr);
           
            //System.out.println("Size="+arr.size());
            //System.out.println("Count="+count+" arr.get(arr.size()-1)-arr.get(0)"+ (arr.get(arr.size()-1)-arr.get(0)));
            if(arr.get(arr.size()-1)-arr.get(0)>max){
            	max=arr.get(arr.size()-1)-arr.get(0);
                if(count==1){
                	
                    season="WINTER";
                   
                }
                else if(count==2){
                    season="SPRING";
                }
                else if(count==3){
                    season="SUMMER";
                }
                else if(count==4){
                    season="AUTUMN";
                }
            }
            count++;
        }
        
        return season;
        
    }
    
    public static void main(String[] v) {
    	
    	Solution1 obj = new Solution1();
    	int[] arr = {-3,-14,-15,7,8,42,8,3};
    	System.out.println(obj.solution(arr));
    	
    	
    }
}