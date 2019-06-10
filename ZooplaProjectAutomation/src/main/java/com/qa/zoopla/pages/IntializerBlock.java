package com.qa.zoopla.pages;

public class IntializerBlock {
	static {
		System.out.println("Static1 Block");
	}

	static {
		System.out.println("Static2 Block");
	}
	{
		System.out.println("Common2 Intializer Block");
	}

	{
		System.out.println("Common1 Intializer Block");
	}

	
	
	static {
		System.out.println("Static3 Block");
	}

	{
		System.out.println("Common3 Intializer Block");
	}

	IntializerBlock() {
		System.out.println("Non Param Constructor");
	}

	IntializerBlock(int i) {
		System.out.println(" Param Constructor");
	}

	public static void main(String[] args) {
		IntializerBlock block = new IntializerBlock();
		IntializerBlock block1 = new IntializerBlock(1);

	}

}
