package reasearchCollection;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K,V, E> extends AbstractMap<K, V> {
	
	static final int SIZE=997;
	LinkedList<MapEntry<K,V>>[] buckets=new LinkedList[997];//数组存放的是linkedList
	
	public V put(K key,V value){
		V oldvalue=null;
		int index=Math.abs(key.hashCode()%SIZE);
		if(buckets[index]==null){
			buckets[index]=new LinkedList<MapEntry<K,V>>();
		}
		LinkedList<MapEntry<K,V>> buck=buckets[index];
		MapEntry<K,V> pair=new MapEntry<K,V>(key,value);
		boolean found=false;
		ListIterator<MapEntry<K, V>> iterator=buck.listIterator();
		while(iterator.hasNext()){
			MapEntry<K,V> ipair=iterator.next();
			if(ipair.getKey().equals(key)){
				oldvalue=ipair.getValue();
				iterator.set(pair);
				found=true;
				break;
			}
			
		}
		if(!found)
			buckets[index].add(pair);
		return oldvalue;
		
	}
	
	public V get(Object key){
		int index=Math.abs(key.hashCode()%SIZE);
		if(buckets[index]==null)
			return null;
		for(MapEntry<K,V> ipair:buckets[index]){
			if(ipair.getKey().equals(key)){
				return ipair.getValue();
				
			}
		}
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set=new HashSet<Map.Entry<K, V>>();
		for(LinkedList<MapEntry<K, V>> bucket:buckets){
			if(bucket==null) continue;
			for(MapEntry<K, V> pair:bucket){
				set.add(pair);
			}
		}
		return set;
	}

}
