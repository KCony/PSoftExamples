package simpleMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;

public class SimpleMap<K, V> {
	private List<K> keys;
	private List<V> values;

	// constructor
	public SimpleMap() {
		keys = new ArrayList<K>();
		values = new ArrayList<V>();
	}

	// add a new key-value pair, return the old value if key already exists
	public V put(K key, V value) {
		int loc = indexOf(key);
		if(loc != -1) {
			V oldValue = values.get(loc);
			values.set(loc, value);
			return oldValue;
		}
		else {
			keys.add(key);
			values.add(value);
			return null;
		}
	}

	// return index of key-value pair with matching key
	// or -1 if not found
	private int indexOf(K key) {
		for (int i = 0; i < keys.size(); i++) {
			if (key.equals(keys.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	// return the keys stored in the map
	public List<K> getKeys() {
		return new ArrayList<K>(keys);
	}
	
	private void checkRep() throws RuntimeException {
		// check for key value list length differences
		if(keys.size() != values.size())
			throw new RuntimeException("Keys-Values length mismatch");
		
		// check for duplicate keys
		Set<K> set = new HashSet<K>(keys);
		if(set.size() < keys.size())
			throw new RuntimeException("Duplicate Keys");
		
		// are there any null values
		for(int i = 0; i < keys.size(); i++) {
			if(keys.get(i) == null)
				throw new RuntimeException("null key");
			if(values.get(i) == null)
				throw new RuntimeException("null value");
		}
	}
	
	public static void main(String[] args) {
		SimpleMap<Date, String> m = new SimpleMap<Date, String>();
		
		m.put(new Date(1000), "cat");
		m.put(new Date(2000), "dog");
		
		List<Date> keyList = m.getKeys();
		for(Date d : keyList) {
			System.out.println(d);
		}
		System.out.println();
		
		keyList.get(1).setTime(3000);

		List<Date> keyList2 = m.getKeys();
		for(Date d : keyList2) {
			System.out.println(d);
		}
		
	}

}
