package com.hashmap;

public class Bucket<K,V> {

	private Entry<K,V> headNode;
	
	private int bucketNo;
	
	public Bucket(int bucketNo){
		this.bucketNo = bucketNo;
	}

	public Entry<K, V> getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Entry<K, V> headNode) {
		this.headNode = headNode;
	}

	public int getBucketNo() {
		return bucketNo;
	}

	@Override
	public String toString() {
		return "Bucket [headNode=" + headNode + ", bucketNo=" + bucketNo + "]";
	}
}
