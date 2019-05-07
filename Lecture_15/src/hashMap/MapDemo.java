package hashMap;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 5/2/19  12:53
public class MapDemo {

	public static void main(String[] args) {
		Map<String, Color> favoriteColors = new HashMap<>();
		// 12:57  Why did we use Map then HashMap?
		// A: polymorphism, variable type is Map, object type is HashMap
		//    We used the constructor for HashMap.
		//    Since HashMap is a subclass of Map, we were able to use HashMap constructor for
		//	  		Map variable type. Much like when we use student class for person class
		// 1:00 Q: what are we gaining from doing it this way?
		//		A: In the future, whenever dealing with favorite colors, we can do it with a map.
		//		   Which could be useful if we wanted to go from HashMap to TreeMap. We should do
		//		   the same thing for LinkedList and ArrayList by using List as variable type.
		//		   It makes this code very flexible which could make a large difference in the future
		favoriteColors.put("Juliet", Color.BLUE);
		favoriteColors.put("Romeo", Color.GREEN);
		favoriteColors.put("Adam", Color.RED);
		favoriteColors.put("Eve", Color.BLUE);
		
		Set<String> keySet = favoriteColors.keySet();
		for(String key : keySet) {
			Color value = favoriteColors.get(key);
			System.out.println(key + ": " + value);
		}
		
	}

}
// 1:08 end of class note, look into linkedBlockingQueue