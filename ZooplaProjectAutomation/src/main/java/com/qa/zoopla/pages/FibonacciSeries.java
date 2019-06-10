package com.qa.zoopla.pages;

public class FibonacciSeries {

	public static void printFibonacciSeries(int num) {

		int one = 0;
		int two = 1;
		
		for (int i = 0; i <num ; i++) {
            System.out.print(one + " ");
            int temp = one + two;
            one = two;
            two = temp;
        }
			
		}
	
	public static void main(String arg[]) {
		
		printFibonacciSeries(10);
	}

	}

