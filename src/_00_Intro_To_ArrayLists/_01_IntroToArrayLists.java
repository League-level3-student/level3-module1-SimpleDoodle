package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
ArrayList<String> stringlist = new ArrayList<String>();
        // 2. Add five Strings to your list
stringlist.add("One");
stringlist.add("Two");
stringlist.add("Three");
stringlist.add("Four");
stringlist.add("Five");
        // 3. Print all the Strings using a standard for-loop
for (int i = 0; i < stringlist.size(); i++) {
	System.out.println(stringlist.get(i));
}
        // 4. Print all the Strings using a for-each loop
for (String string : stringlist) {
	System.out.println(string);
}
        // 5. Print only the even numbered elements in the list.
for (int i = 0; i < stringlist.size(); i++) {
	if (i%2 == 0) {
		System.out.println(stringlist.get(i));
	}
}
        // 6. Print all the Strings in reverse order.
for (int i = 4; i > -1; i--) {
	System.out.println(stringlist.get(i));
}
        // 7. Print only the Strings that have the letter 'e' in them.
for (int i = 0; i < stringlist.size(); i++) {
	if (stringlist.get(i).contains("e") ) {
		System.out.println(stringlist.get(i));
	}
}
    }
}
