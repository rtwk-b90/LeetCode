package com.algo;

import java.util.Arrays;

public class ThreeMaxProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxProduct(new int[] {-5,4,2,-6,7,-8}));
	}
	static int getMaxProduct(int[] d) {
		
	Arrays.sort(d);
	int max= d[0]*d[1]*d[d.length-1];
	max=Math.max(max, d[d.length-1]*d[d.length-2]*d[d.length-3]);
		
		
		
		return max;
	}
}
