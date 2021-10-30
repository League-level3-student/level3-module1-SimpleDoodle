package _03_RemovingStuffFromArrayLists;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListRemove {

    class Stuff {
        public String type;
    }
    
    class Worm extends Stuff {
        public Worm() {
            type = "worm";
        }
    }
    
    class Dirt extends Stuff {
        public Dirt() {
            type = "dirt";
        }
    }

    // 1. Write a method that removes the dirt in the yard and returns the
    //    ArrayList
    public static ArrayList<Stuff> cleanOutTheYard( ArrayList<Stuff> yard ) {
        for (Stuff stuff : yard) {
			if (stuff.type.equalsIgnoreCase("dirt")) {
				yard.remove(stuff);
			}
		}
        return yard;
    }
    
    // 2. Write a method that removes the hash tag ('#') characters from the
    //    ArrayList and returns it
    public static ArrayList<Character> removeHashTags(ArrayList<Character> list) {
    	for (Character character : list) {
			if (character.equals("#")) {
				list.remove(character);
			}
		}
        return list;
    }
}
