package com.springpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
	private static long countOccuranceInList(List<String> names, String eachName) {
		return names.stream().filter(e -> (e != null) && e.equals(eachName)).count();
	}

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("satya");
		names.add("satya");
		names.add("satya");
		names.add("satyam");
		names.add("is");
		names.add("is");
		names.add("o");
		names.add("and");
		names.add(null);

		System.out.println(names);
		List<String> names2 = names.stream().filter(e -> e != null).distinct().toList();
		System.out.println(names2);
		names2.stream().forEach(
				eachName -> System.out.println(eachName + " count -> " + countOccuranceInList(names, eachName)));
//1
		System.err.println("stram questions");
		System.err.println("---------------");
		// give a list of integrs, find out all the numbers starting with 1 using stram
		// function
		System.err.println("1. give a list of integrs, find out all the numbers starting with 1 using stram function?");

		List<Integer> myList1 = Arrays.asList(123, 45, 189, 102, 867, 19, 176);
		List<Integer> numbersStartingWithOne = myList1.stream().filter(num -> String.valueOf(num).startsWith("1"))
				.collect(Collectors.toList());
		System.out.println(numbersStartingWithOne);

		// how to find duplicate elements in a given integers list in java usinf stram
		// functio
		System.err.println("2. how to find duplicate elements in a given integers list in java usinf stram functio");
		List<Integer> myList2 = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 7, 8, 9, 3);
		List<Integer> duplicateElements = myList2.stream().collect(Collectors.groupingBy(i -> i)).entrySet().stream()
				.filter(entry -> entry.getValue().size() > 1).map(entry -> entry.getKey()).collect(Collectors.toList());
		System.out.println(duplicateElements);

		// Give the list of integers , find the total number of elements present in the
		// list using stream functions
		System.err.println(
				"3. Give the list of integers , find the total number of elements present in the list using stream functions");
		List<Integer> myList3 = Arrays.asList(1, 2, 3, 4, 5);
		long totalElements = myList3.stream().count();
		System.out.println("Total number of elements: " + totalElements);

		// Give the list of integers , find the maximum value element present in it
		// using stream function
		System.err.println(
				"4. Give the list of integers , find the maximum value  element  present in it using stream function");
		List<Integer> myList4 = Arrays.asList(1, 5, 3, 8, 2);
		Optional<Integer> maxElement = myList4.stream().max(Integer::compareTo);
		System.out.println(maxElement);

		// Give the list of integers , find the first element of the list using strams
		// functions
		System.err.println("5. Give the list of integers , find the first element  of the list using strams functions");
		List<Integer> myList5 = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstElement = myList5.stream().findFirst();
		System.out.println(firstElement);

		// give a list of integrs, sort all the values present in it descending order
		// using stream functions
		System.err.println(
				"6. give a list of integrs, sort all the values present in it descending order using stream functions");
		List<Integer> myList6 = Arrays.asList(5, 2, 8, 1, 3);
		List<Integer> sortedList = myList6.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
		System.out.println(sortedList);

//2		 
		System.err.println("Java 1.7 intermediate questions stram questions");
		System.err.println("------------------------------------------------");

		// print 3rd highest from array using java streams
		System.err.println("print 3rd highest from array using java streams");
		int[] myArray = { 10, 5, 8, 15, 2, 7, 12 };
		int thirdHighest = Arrays.stream(myArray).boxed() // Convert int to Integer for stream operations
				.sorted((a, b) -> b.compareTo(a)).distinct().skip(2) // Skip the first two elements (1st and 2nd highest)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Array is too small to find the 3rd highest element."));
		System.out.println(thirdHighest);
		
		
		
		System.err.println("revers a give string . i/p =satyam using java stram");
		   String input = "satyam";
		   //example 1
		   String reversed = new StringBuilder(input).reverse().toString();
		   System.out.println("Reversed string example 1: " + reversed);
		 //example 2
		   String reversed1 = IntStream.range(0, input.length())
	                .mapToObj(i -> input.charAt(input.length() - 1 - i))
	                .map(String::valueOf)
	                .collect(Collectors.joining());
		   System.out.println("Reversed string example 2: " + reversed1);
		   
		   
		   
		   
	}

}
