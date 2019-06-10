package com.qa.zoopla.testcases;
import java.util.*;

import org.testng.annotations.Test;


class TestClass {
	
	@Test
	public void fizz() {
     Scanner t = new Scanner(System.in);
     int testCases = t.nextInt();                
     System.out.println("Enter testcases"+testCases); 
 
 
 
 
 if(testCases>=1 != testCases <=10){
     int number=3;
     if(number%3==0){
         System.out.println("Fizz");
     }
     
     else if (number%5==0){
         System.out.println("Buzz"); 
     }
     
     else if (number%3 ==0 && number%5==0){
         System.out.println("FizzBuzz"); 
     }
 }
 
 else {
     System.out.println("Test Case(s) entered by User should be 1 to 10");
 }

 }
}

