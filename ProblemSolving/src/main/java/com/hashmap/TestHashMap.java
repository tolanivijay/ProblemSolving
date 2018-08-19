package com.hashmap;

public class TestHashMap {

	public static void main(String[] args) {
		MyHashMap<String,String> map = new MyHashMap<String,String>();
		map.put("one", "one");
		map.put("two", "two");
		map.put("three", "three");
		map.put("four", "four");
		map.put("five", "five");
		map.put("six", "six");
		map.put("seven", "seven");
		
		System.out.println("Occupied Buckets are "+ map.getOccupiedBuckets());
		
		System.out.println("map.get(\"five\")" + map.get("five"));
		System.out.println("map.get(\"six\")" + map.get("six"));
		System.out.println("map.get(\"two\")" +map.get("two"));
		System.out.println("map.get(\"eight\")" + map.get("eight"));

	}

}
