package com.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyHashMap<K,V> {

	private int loadFactor = 16;
	
	private int size = 0;
	
	private List<Bucket<K,V>> buckets = new ArrayList<Bucket<K,V>>();
	
	public MyHashMap() {
		constructBuckets();
	}
	
	public void put(K key, V value) {
		addToBucket(key,value,calculateBucketNo(key));
		size++;
	}
	
	private int calculateBucketNo(K key) {
		int bucketNo = 0;
		if (key != null) {
			bucketNo = key.hashCode()%loadFactor;
		}
		return bucketNo;
	}
	
	public V get(K key) {
		Bucket<K,V> bucket = buckets.get(calculateBucketNo(key));
		return findValue(bucket,key);
	}
	
	public List<Bucket<K,V>> getOccupiedBuckets(){
		return buckets.stream().filter(b -> b.getHeadNode() != null).collect(Collectors.toList()); 
	}
	
	private V findValue(Bucket<K,V> bucket, K key) {
		V returnValue = null;
		Entry<K,V> entry = bucket.getHeadNode(); 
		if (entry == null) {
			return returnValue;
		}
		if (entry.getKey().equals(key)) {
			return entry.getValue();
		}
		while (entry.getNextEntry() !=null) {
			entry = entry.getNextEntry();
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return returnValue;	
	}
	
	private void addToBucket(K key, V value,int bucketNo) {
		Bucket<K,V> bucket = buckets.get(bucketNo);
		Entry<K,V> entry = bucket.getHeadNode();
		Entry<K,V> newEntry = new Entry<K,V>(key, value);
		
		if (entry == null) {
			bucket.setHeadNode(newEntry);
			return;
		}
		Entry<K,V> currentNode = entry;
		while (entry.getNextEntry() != null) {
			currentNode = entry.getNextEntry();
		}
		currentNode.setNextEntry(newEntry);
		
	}
	
	private void constructBuckets() {
		for (int i = 0;i <loadFactor;i++) {
			buckets.add(new Bucket<K,V>(i));
		}
	}
}
