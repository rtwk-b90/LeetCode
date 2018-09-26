package com.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Hotel {

	
    static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {

    HashMap<Integer,Integer> hMap= new HashMap();
        List<String[]> rList = new ArrayList();
        
        for(int c=0;c<reviews.size();c++){
            
            String[] rev=reviews.get(c).split(" ");
            rList.add(rev);
        }
        
        
        String[ ] keyArr= keywords.split(" ");
        System.out.println("keyArr="+keyArr.length);
       
        for(int i=0;i<hotel_ids.size();i++){
             for(int j=0;j<keyArr.length;j++){
                 
                 for(int k=0;k<rList.get(i).length;k++){
                     System.out.println(rList.get(i)[k]);
                     if((rList.get(i))[k].toUpperCase().contains(keyArr[j].toUpperCase())){
                        
                        if( hMap.containsKey(hotel_ids.get(i))){
                        	System.out.println("Inside "+hotel_ids.get(i));
                           int count= hMap.get(hotel_ids.get(i));
                            count++;
                            hMap.put(hotel_ids.get(i),count);
                        }
                         else{
                        	 System.out.println("Inside else"); 
                             hMap.put(hotel_ids.get(i),0);
                         }
                     }
                     
                 }
                
                     
                 }
             System.out.println("This was for "+hotel_ids.get(i));
             }
           List<int[]> ls= new ArrayList();
           System.out.println(hMap);
        for (Integer key : hMap.keySet()) {
        Integer value = hMap.get(key);
            int[] tmp= new int[2];
            tmp[0]=key;
             tmp[1]=value;
            ls.add(tmp);
            
        
    }
        System.out.println("name="+ls.get(0)[0]+" value="+ls.get(0)[1]);
        System.out.println("name="+ls.get(1)[0]+" value="+ls.get(1)[1]);
      //  Collections.sort(ls,(a,b)->Integer.compare(b[1],a[1]));
        Collections.sort(ls, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o2[1]>o1[1])
					return 1;
				else if(o2[1]<o1[1])
					return -1;
				else {
					if(o2[0]==o1[0]) {
						return 0;
					}
				}
				return 0;
			}
        	
        	
        	
		});
       
        List<Integer> result = new ArrayList();
       
        for(int l=0;l<ls.size();l++){
            result.add(ls.get(l)[0]);
            
        }
        return result;
        }
    
    
    public static void main(String[] v) {
    	String keywords= "breakfast beach citycenter location metro view staff price"; 
    	
    	List<Integer> hotel_ids= new ArrayList();
    	hotel_ids.add(1);
    	hotel_ids.add(2);
    	hotel_ids.add(1);
    	hotel_ids.add(1);
    	hotel_ids.add(2);
    	
    	List<String> reviews= new ArrayList();
    	reviews.add("The hotel has a nice view of citycenter. The location is perfect, and breakfast is good");
    	reviews.add("The breakfast is okay. Regarding location , it is quite far from citycenter . but price is cheap");
    	reviews.add("Location is excellent, 5 minutes from citycenter. A metro station close.");
    	reviews.add("This is not fair");
    	reviews.add("Good staff. Location bit far from citycenter");
    	
    	
    	Hotel obj = new Hotel();
    	System.out.println(obj.sort_hotels(keywords, hotel_ids, reviews));
    }

}
