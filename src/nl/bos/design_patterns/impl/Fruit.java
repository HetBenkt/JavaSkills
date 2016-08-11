/**
 * 
 */
package nl.bos.design_patterns.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import static nl.bos.design_patterns.IConstants.*;
/**
 * @author bosa
 *
 */
public class Fruit {
	private static Map<FruitType, Fruit> types = new HashMap<>();
	
	private Fruit(FruitType type) {
	}

	public static Fruit getFruitByTypeName(FruitType type) {
		Fruit result = null;
		
		if(!types.containsKey(type)) {
			result = new Fruit(type);
			types.put(type, result);
		} else {
			result = types.get(type);
		}
		
		return result;
	}

	public static void showAll() {
		System.out.println(String.format(STR_SEPERATOR, STR_EMPTY));
		for(Entry<FruitType, Fruit> entry : types.entrySet()) {
			System.out.println(entry.getKey().toString());
		}
	}
}
