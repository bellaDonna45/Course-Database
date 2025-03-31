package coursedatabasepackage;


import java.util.LinkedList;


public class MyHashTable<K, V> {
	  private static final double MAX_LOAD_FACTOR = 0.7;
	    int bucketCount;
	    private int itemCount;
	    LinkedList<Entry<K, V>>[] buckets;

	    public MyHashTable(int initialSize) {
	    	this.bucketCount = nextPrime(initialSize); 
	        initializeBuckets();
	    }

	    private void initializeBuckets() {
	        this.itemCount = 0;
	        buckets = new LinkedList[bucketCount];
	        for (int i = 0; i < bucketCount; i++) {
	            buckets[i] = new LinkedList<>();
	        }
	    }

	    private int hashFunction(K key) {
	        return Math.abs(key.hashCode()) % bucketCount;
	    }

	    public void put(K key, V value) {
	        if ((double) itemCount / bucketCount > MAX_LOAD_FACTOR) {
	            resize();
	        }
	        int index = hashFunction(key);
	        for (Entry<K, V> entry : buckets[index]) {
	            if (entry.key.equals(key)) {
	                entry.value = value;
	                return;
	            }
	        }
	        buckets[index].add(new Entry<>(key, value));
	        itemCount++;
	    }

	    public V get(K key) {
	        int index = hashFunction(key);
	        for (Entry<K, V> entry : buckets[index]) {
	            if (entry.key.equals(key)) {
	                return entry.value;
	            }
	        }
	        return null;
	    }

	    public boolean containsKey(K key) {
	        return get(key) != null;
	    }

	    public boolean remove(K key) {
	        int index = hashFunction(key);
	        for (Entry<K, V> entry : buckets[index]) {
	            if (entry.key.equals(key)) {
	                buckets[index].remove(entry);
	                itemCount--;
	                return true;
	            }
	        }
	        return false;
	    }

	    private void resize() {
	        int newSize = nextPrime(bucketCount * 2);
	        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
	        bucketCount = newSize;
	        initializeBuckets();
	        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
	            for (Entry<K, V> entry : bucket) {
	                put(entry.key, entry.value);
	            }
	        }
	    }

	    int nextPrime(int num) {
	    	 while (!isPrime(num)) {
	    	        num--;
	    	    }
	    	    return num;
	    }

	    private boolean isPrime(int num) {
	        if (num < 2) return false;
	        for (int i = 2; i * i <= num; i++) {
	            if (num % i == 0) return false;
	        }
	        return true;
	    }

	    static class Entry<K, V> {
	        K key;
	        V value;
	        Entry(K key, V value) {
	            this.key = key;
	            this.value = value;
	        }
	    }
	    }