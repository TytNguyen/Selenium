package Section14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class test1 {
	//count the number of names starting with alphabet A in the list
	@Test
	public void regular() {
		List<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		int count = 0;
		
		for (String name:names) {
			if (name.startsWith("A")) {
				count ++;
			}
		}
		System.out.println(count);
	}
	
	@Test
	public void streamFilter() {
		List<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		//There is no life for intermediate op if there is no terminal op
		//terminal operation will execute only if inter op (filter) returns true
		//We can create stream 
		//how to use filter in Stream API
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		Long d = Stream.of("Abhijeet", "Don", "Adam", "Alekhya", "Ram").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);

		//print all the names of ArrayList
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamMap() {
		List<String> names = new ArrayList<String>();
		names.add("men");
		names.add("Don");
		names.add("women");
		
		//print names which have last letter as "a" with Uppercase
		Stream.of("Abhijeet", "Don", "Adam", "Alekhya", "Rama").filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase()).forEach(s->System.out.println(s));;
		
		System.out.println("-------------------------------------");
		
		//print names which have first letter as "a" with Uppercase and sorted
		List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Adam", "Alekhya", "Rama");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));

		System.out.println("-------------------------------------");
		
		//Merging  2 different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Abhijeet", "Don", "Adam", "Alekhya", "Rama").filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		System.out.println("-------------------------------------");

		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		//print unique number from this array
		//sort this array
		values.stream().distinct().forEach(s->System.out.println(s));	
		
		System.out.println("-------------------------------------");

		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));

		
	}
}
