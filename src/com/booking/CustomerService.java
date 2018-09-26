package com.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> time= new ArrayList(); 
		List<Integer> arr= new ArrayList();
		arr.add(00);
		arr.add(20);
		time.add(arr);
		
		arr= new ArrayList();
		arr.add(00);
		arr.add(40);
		
		time.add(arr);
		arr= new ArrayList();
		arr.add(30);
		arr.add(35);
		time.add(arr);
		
		arr.add(30);
		arr.add(35);
		time.add(arr);
		
		arr.add(30);
		arr.add(35);
		time.add(arr);
		
		System.out.println(CustomerService.howManyAgentsToAdd(1, time));
	}

	public static int howManyAgentsToAdd(int noOfConcurrentAgents,List<List<Integer>> callsTimes) {
		
		int count=0;
		
		Collections.sort(callsTimes,(a,b)-> Integer.compare(b.get(1), a.get(1)));
		for(int i=1;i<callsTimes.size();i++) {
			boolean continueFlg=false;
			for(int j=0;j<i;j++) {
				
				if(callsTimes.get(i).get(0)<=callsTimes.get(j).get(1) && callsTimes.get(i).get(0)>=callsTimes.get(j).get(0)) {
					count++;
					continueFlg=true;
				}else if(callsTimes.get(i).get(1)<=callsTimes.get(j).get(1) && callsTimes.get(i).get(1)>=callsTimes.get(j).get(0)) {
					count++;
					continueFlg=true;
				}
				if(continueFlg) {
					break;
				}
				
			}
		}
		
		
		return count>noOfConcurrentAgents?count-noOfConcurrentAgents:0;
		
	}
}
