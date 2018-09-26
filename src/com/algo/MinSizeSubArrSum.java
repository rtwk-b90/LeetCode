package com.algo;

public class MinSizeSubArrSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
	}

	 static int minSubArrayLen(int s, int[] nums) {
	        if (s <= 0 || nums == null || nums.length == 0) {
	            return 0;
	        }
	         
	        int lo = 0;
	        int hi = 0;
	        int sum = 0;
	        int minLen = Integer.MAX_VALUE;
	         
	        while (hi < nums.length) {
	            // Moves the hi pointer
	            while (hi < nums.length && sum < s) {
	                sum += nums[hi];
	                hi++;
	            }
	             
	            // Move the lo pointer
	            while (lo <= hi && sum >= s) {
	                minLen = Math.min(minLen, hi - lo);
	                sum -= nums[lo];
	                lo++;
	            }
	        }
	        if (minLen == Integer.MAX_VALUE) {
	            return 0;
	        } else {
	            return minLen;
	        }
	    }
}
