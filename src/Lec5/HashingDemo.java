package Lec5;

import java.util.*;

public class HashingDemo {

	public static void main(String[] args) {
//		HashMap<String, Integer> hashmap = new HashMap<>();
//		hashmap.put("Mihir",100); // O(1)
//		hashmap.put("Rohit", 95);
//		hashmap.put("Harshit", 110);
//		
////		System.out.println(hashmap.get("Mihir")); // O(1)
////		System.out.println(hashmap.get("Rohan"));
//		System.out.println(hashmap.containsKey("Mohit")); // O(1)
//		hashmap.put("Mihir", 200); 
//		System.out.println(hashmap);
//		hashmap.remove("Rohit");
//		System.out.println(hashmap);
		
		HashSet<Integer> set = new HashSet<>();
		// just like a set it can store only unique values
		set.add(10); // O(1)
		set.add(20);
		set.add(30);
		System.out.println(set.size());
		set.add(20);
		set.add(20);
		System.out.println(set.size());
		System.out.println(set.contains(30)); // O(1)
		System.out.println(set.contains(40));
		set.remove(30); // O(1)
		System.out.println(set.size());
		System.out.println(set.contains(30));
		
//		TreeMap<> treemap = new TreeMap<>();
//		is just like hashmap but it stores keys in increasing order
		

	}

}
