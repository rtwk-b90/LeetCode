package com.algo;

public class MaxProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProduct prod=new MaxProduct();
		System.out.println(prod.getMaxProduct(new int[] {1,3,2,-5,-3,-6}));

	}
	
	int getMaxProduct(int[] d) {
		int max=1;
		int min=1;
		int max2=1;
		for(int i=0;i<d.length;i++) {
			int max3=max;
			max=Math.max(max*d[i],min*d[i] );
			min=Math.min(max3*d[i],min*d[i] );
			max2=Math.max(max,max2);
		}
		
		
		return max2;
	}

}
