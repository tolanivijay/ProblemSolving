package com.hashmap;

public class Entry<K,V> {

	private K key;
	
	private V value;
	
	private Entry<K,V> nextEntry;
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}



	public Entry<K, V> getNextEntry() {
		return nextEntry;
	}



	public void setNextEntry(Entry<K, V> nextEntry) {
		this.nextEntry = nextEntry;
	}

	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + ", nextEntry=" + nextEntry + "]";
	}
	
}
