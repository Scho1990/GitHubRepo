package com.qa.zoopla.testcases;

import java.util.Scanner;

public class HackerRankTest {

	public static void main(String arg[]) {

		Scanner test = new Scanner(System.in);
		System.out.println("Total number of test cases to execute:");
		int totalTestCases = test.nextInt();
		System.out.println(totalTestCases);
		
		Scanner n = new Scanner(System.in);
		System.out.println("Enter Number:");
		int number = n.nextInt();
		System.out.println(number);

		if (totalTestCases >= 1 && totalTestCases <= 10) {
            for(int i=1;i<=number;i++) {
            	if(number%3==0) {
            		System.out.println("Fizz");
            		continue;
            	}
            	
            	else if(number%5==0) {
            		System.out.println("Buzz");
            		continue;
            	}
            	
            	else if(number%3==0 && number%5==0) {
            		System.out.println("FizzBuzz");
            		continue;
            	}
            }
		}

		else {
			System.out.println("Please enter testcases between 1 to 10");
		}

	}

}
