package reasearchCollection;

import java.util.TreeMap;

import net.mindview.util.CountingMapData;
import static net.mindview.util.Print.*;




public class SortedMapDemo {

	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap=new TreeMap<Integer, String>(new CountingMapData(10));
		print(treeMap);
		Integer low=treeMap.firstKey();
		Integer high=treeMap.lastKey();
		

	}

}
