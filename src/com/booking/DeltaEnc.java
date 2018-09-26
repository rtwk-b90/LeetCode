package com.booking;

import java.util.ArrayList;

public class DeltaEnc {

	static int[] delta_encode(int[] array) {
        /*
         * Write your code here.
         */
        if(array==null)
            return null;
        if(array.length==0)
            return null;
        if(array.length==1){
            return array;
        }
        
        int size=array.length;
        ArrayList<Integer> list= new ArrayList();
        
        list.add(array[0]);
        for(int i=1;i<size;i++){
            
            int val=array[i]-array[i-1];
            if(val> 127 || val<= -128){
                
                list.add(-128);
            }
            list.add(val);
            
            
        }
        
       int[] arr2= new int[list.size()];
        for(int j=0;j<list.size();j++){
            arr2[j]=list.get(j);
            
        }
        return arr2;
    }

}
