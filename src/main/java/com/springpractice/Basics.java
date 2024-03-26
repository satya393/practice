package com.springpractice;

import java.awt.Container;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.util.comparator.Comparators;

public class Basics {

	public static void main(String[] args) {
//		reversAstring();
//		lastObject();
//		filterExamples();
		group();
	}

	public static void reversAstring() {

		String input = "hi i am satya";
		String[] arrays = input.split(" ");

		for (int i = arrays.length - 1; i >= 0; i--) {
			System.out.print(arrays[i] + " ");
		}
		System.out.println();
	}

	record Students(Integer id, String name, Integer age, Integer fee, Boolean status) {

	}

	public static void lastObject() {

		List<Integer> list = Arrays.asList(1, 0, 2, 3, 4, 5, 34, 1, 2, 3, 4, 5, 7, 98, 34, 98);

		Integer lastRowFirstValue = list.stream().skip(list.size() - 1).findFirst().get();
		Integer firsttRowFirstValue = list.stream().skip(0).findFirst().get();
		Integer firstValue = list.stream().findFirst().get();

		System.out.println(lastRowFirstValue);
		System.out.println(firsttRowFirstValue);
		System.out.println(firstValue);

		Integer maxValue = list.stream().max(Integer::compare).get();
		Integer minValue = list.stream().min(Integer::compare).get();

		System.out.println(maxValue);
		System.out.println(minValue);

		List<Integer> ascending = list.stream().sorted().toList();
		List<Integer> descending = list.stream().sorted(Comparator.reverseOrder()).toList();
		List<Integer> distinct = list.stream().sorted().distinct().toList();

		List<Students> studentList = Arrays.asList(new Students(1, "satya", 12, 12000, false),
				new Students(2, "atya", 12, 13000, true), new Students(3, "ctya", 13, 15000, true),
				new Students(4, "ctya", 13, 12000, true), new Students(5, "ctya", 13, 11000, true),
				new Students(6, "ctya", 13, 150, true), new Students(7, "ctya", 13, 18000, true),
				new Students(8, "ctya", 13, 25000, true), new Students(9, "btya", 2, 17000, false));
		List<Students> targetingToSort = studentList.stream().sorted(Comparator.comparing(Students::name))
				.collect(Collectors.toList());

		Students maxfee = studentList.stream().max(Comparator.comparing(Students::fee)).get();
		Students minfee = studentList.stream().min(Comparator.comparing(Students::fee)).get();

		Collections.reverse(studentList);
		List<Students> revers5List = studentList.stream().limit(5).toList();
		System.out.println("limit" + revers5List);
		Collections.reverse(studentList);

		List<Students> emptyTheList = Collections.emptyList();// using collections
		Stream<Students> emptyStream = Stream.empty();// using streams

		Integer fees = 1000;
		List<Students> morethan1100 = studentList.stream().filter(e -> e.fee() >= fees).toList();
		List<Integer> mapList = morethan1100.stream().map(Students::fee).sorted().toList();
		System.out.println("mapList" + mapList);
		studentList.stream().filter(e -> e.name.contains("sa")).forEach(e -> System.out.println(e));

		System.out.println(ascending);
		System.out.println(descending);
		System.out.println(distinct);
		System.out.println(targetingToSort);
		System.out.println(emptyTheList);
		System.out.println(emptyStream.count());
		System.out.println(maxfee);
		System.out.println(minfee);
		System.out.println(morethan1100);

	}

	record Family(Integer id, String name, Integer age, String relation, Integer salery) {

	}

	public static void filterExamples() {

		List<Family> familtList = Arrays.asList(new Family(1, "satyam", 56, "grandFather", 244444),
				new Family(3, "satya", 28, "grandSon", 24434), new Family(2, "satyanarayana", 64, "Father", 234), null,
				new Family(4, "null", null, "Father", 554), new Family(5, "nagavani", 3, "grandmother", 123));

		familtList.stream().filter(e -> e != null && e.name.contains("sat")).forEach(e -> System.out.println(e.name));

		familtList.stream().filter(e -> e != null && e.age != null).forEach(Family -> System.out.println(Family.age));

		familtList.stream().filter(e -> e != null && e.age != null && e.age % 2 == 0).forEach(System.out::println);

		familtList.stream().filter(e -> e != null && e.age != null && e.age.equals(3)).forEach(System.out::println);

		System.out.println(familtList.stream().count());

		System.out.println(familtList.stream().filter(e -> e != null && e.id >= 3).toList());

		familtList.stream().filter(Objects::nonNull).sorted(Comparator.comparing(Family::id))
				.forEach(System.out::println);

		System.out.println(familtList.stream().filter(e -> e != null && e.name.length() > 3).count());

		familtList.stream().filter(e -> e != null).map(e -> e.name.toUpperCase())
				.forEach(e -> System.out.println("names: " + e));

		familtList.stream().filter(e -> e != null).map(e -> e.name.toUpperCase() + "`s")
				.forEach(e -> System.out.println("names: " + e));

		double persentage = 1.62;
		familtList.stream().filter(e -> e != null).map(e -> e.salery * persentage).forEach(e -> System.out.println(e));
	}

	public static void group() {
		
		 
		List<String> namesList = Arrays.asList("satya", "sajid",null, "prasanth","sahid");
		 
//		System.out.println( namesList.stream().filter(e -> e !=null).anyMatch(e -> e.equalsIgnoreCase("sajid")));
		namesList.stream().filter(e -> e !=null && !e.contains("satya")).toList().forEach(e-> System.out.println(e));
		System.out.println(namesList.stream().skip(1).toList());
		 namesList.stream().skip(namesList.size()-1).forEach(e -> System.out.println(e));
		 namesList.stream().filter(e -> e!=null).sorted(Comparator.reverseOrder()).forEach(e-> System.out.println(e));
		 Collections.reverse(namesList);
		System.out.println( namesList.stream().toList());
	}

}
