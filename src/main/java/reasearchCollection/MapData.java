package reasearchCollection;



import general.Generator;

import java.util.LinkedHashMap;



public class MapData<K,V> extends LinkedHashMap<K, V> {
	
	public MapData(Generator<Pair<K, V>> gen,int quantity){
		for(int i=0;i<quantity;i++){
			Pair<K, V> p=gen.next();
			put(p.key, p.value);
		}
	}

	public MapData( Generator<K> k,Generator<V> v , int quantity ){
		for(int i=0;i<quantity;i++)
			put(k.next(), v.next());
	}
	
	public MapData( Generator<K> k, V v , int quantity ){
		for(int i=0;i<quantity;i++)
			put(k.next(), v);
	}
	
	public MapData(Iterable<K> k,Generator<V> v){
		for(K key:k)
			put(key,v.next());
	}
	
	public static <K,V> MapData<K,V> map(Generator<Pair<K, V>> gen,int quantity){
		return  new  MapData<K,V>(gen,quantity);
	}
	
	public static <K,V> MapData<K,V> map( Generator<K> k,Generator<V> v , int quantity){
		return  new  MapData<K,V>(k,v,quantity);
	}
	
	public static <K,V> MapData<K,V> map( Generator<K> k, V v , int quantity){
		return  new  MapData<K,V>(k,v,quantity);
	}
	
	public static <K,V> MapData<K,V> map(Iterable<K> k,Generator<V> v){
		return  new  MapData<K,V>(k,v);
	}
	
}
