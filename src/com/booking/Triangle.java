package com.booking;

public class Triangle {
	
	static int triangle(int a, int b, int c) {

        if(a <=0 ||b<=0||c<=0){
            return 0;
        }
        if(a==b && b==c){
            return 1;
        }
        
        if(a+b >c ){
            return 2;
        }
        
        return 0;

    }


}
