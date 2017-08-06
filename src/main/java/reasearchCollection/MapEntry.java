package reasearchCollection;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K,V>{

	private K key;
	private V value;

	public MapEntry(K key,V value) {
		this.key=key;
		this.value=value;
	}
	
	
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public V setValue(V value) {
		V relust=this.value;
		this.value=value;
		
		return relust;
	}

}
