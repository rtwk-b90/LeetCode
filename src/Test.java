// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
class Test {
    public int solution(String S) {
        // write your code in Java SE 8
        HashMap<Integer,Integer> hm = new HashMap();
        String[] records= S.split("\n");
        
        for(String str: records){
            String[] rec=str.split(",");
             String[] duration=rec[0].split(":");
                
               int sum=Integer.parseInt(duration[0])*3600+Integer.parseInt(duration[1])*60+Integer.parseInt(duration[2]);
              
               String ph= rec[1].replace("-","");
            if(hm.get(Integer.parseInt(ph))!=null){
                sum=sum+hm.get(Integer.parseInt(ph));
                 hm.put(Integer.parseInt(ph),sum);
                
                
            }else{
               
                hm.put(Integer.parseInt(ph),sum);
                
            }
            
        }
        ArrayList<int[]> arr = new ArrayList<int[]>();
        for (Integer key : hm.keySet()) {
        System.out.println("Key = " + key);
        System.out.println("Val = " + hm.get(key));
        int[] row= new int[2];
        row[0]=key;
        row[1]=hm.get(key);
        arr.add(row);
        
        }
        
         Collections.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
         
         int minDuration=arr.get(0)[1];
         int ph=arr.get(0)[0];
          int cents=0;
         for(int i=1;i<arr.size();i++){
             
             if(minDuration!=arr.get(i)[1]){
                 if((arr.get(i)[1])<300){
                	 System.out.println( arr.get(i)[1]*3);
                    return  arr.get(i)[1]*3;
                 }
                 System.out.println(  "--2we--"+Math.ceil((arr.get(i)[1]/60)) *150);
                  cents=  (arr.get(i)[1]/60)*150;
                 return cents;
             }else{
                 
                if(ph>arr.get(i)[0]){
                 if((minDuration)<300){
                	 
                    return  minDuration*3;
                 }
                 System.out.println( "--ww-w-"+ Math.ceil((minDuration/60)) *150);
                  cents=  (minDuration/60)*150;
                 return cents;
                }else{
                    
                     if(((arr.get(i)[1])<300)){
                    return  arr.get(i)[1]*3;
                 }
                     System.out.println( "----"+Math.ceil((arr.get(i)[1]/60)) *150);
                  cents=  (arr.get(i)[1]/60)*150;
                 return cents;
                }
                }
                
                
             }
         System.out.println(cents+"111");
             return cents;
             
         }

        public static void main(String[] v) {
        	Test obj = new Test();
        	
        	String s="00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,401-234-090";
        	System.out.println(obj.solution(s));
        }
        
    }
