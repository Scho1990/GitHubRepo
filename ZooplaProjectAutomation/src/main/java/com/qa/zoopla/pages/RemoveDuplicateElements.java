package com.qa.zoopla.pages;

import java.util.*;

public class RemoveDuplicateElements {

	// Function to remove duplicates from an ArrayList
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

		// Create a new ArrayList
		ArrayList<T> newList = new ArrayList<T>();

		// Traverse through the first list
		for (T element : list) {

			// If this element is not present in newList
			// then add it
			if (!newList.contains(element)) {

				newList.add(element);
			}
		}

		// return the new list
		return newList;
	}

	public static <T> void getFirstAndLastElementFromArrayList(ArrayList<T> list) {

		int size = list.size();

		System.out.println("First element is  " + list.get(0));

		System.out.println("Last Element is  " + list.get(size - 1));

	}

	// Driver code
	public static void main(String args[]) {
		

		// Get the ArrayList with duplicate values
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 10, 2, 4, 6,8));

		// Print the Arraylist
		System.out.println("ArrayList with duplicates: " + list);

		// Remove duplicates
		ArrayList<Integer> newList = removeDuplicates(list);

		// Print the ArrayList with duplicates removed
		System.out.println("ArrayList with duplicates removed: " + newList);
		
		getFirstAndLastElementFromArrayList(list);
		
		
	}
}