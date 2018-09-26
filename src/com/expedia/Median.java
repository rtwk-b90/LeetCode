package com.expedia;

import java.util.PriorityQueue;
import java.util.Queue;

public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Median ob= new Median();
		ob.addNum(6);
		ob.addNum(10);
		ob.addNum(2);
		System.out.println(ob.findMedian());
		ob.addNum(6);
		System.out.println(ob.findMedian());
		ob.addNum(5);
		System.out.println(ob.findMedian());
 	}

	


    private Queue<Long> small = new PriorityQueue(),
                        large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
               ? large.peek()
               : (large.peek() - small.peek()) / 2.0;
    }
}
