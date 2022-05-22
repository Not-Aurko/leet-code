import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Aurko
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 */
public class Solution {
    public static String frequencySort(String s) {
        StringBuilder result = new StringBuilder(); // Use String builder to create the String

        if ( s == null || s.length() == 0 ) {
            return result.toString();
        }   // if empty string was provided return the result here

        // Use a Map of Character to integer where we use the character as the key and integer as the count
        // When we insert the char, do a get for the char to get the current count and add one
        Map<Character, Integer> charCount = new HashMap<>();
        for ( char c : s.toCharArray() ) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }


        // Make the Heap and compare the two elements by their character count.
        // To construct the maxHeap, pass in a Comparator to the constructor b-a
        PriorityQueue<Character> maxHeap = new PriorityQueue<>( (a,b) -> charCount.get(b).compareTo(charCount.get(a)) );
        // Add all the elements to our maxHeap
        for ( char c : charCount.keySet() ) {
                maxHeap.add(c);
        }

        while (!maxHeap.isEmpty()) {            // While the Heap is not empty
            char current = maxHeap.remove();    // Remove the current char
            int count = charCount.get(current); // See how many times it has occured
            for ( int i = 0; i < count; i++ ) { // Add it to the String based on its respective frequency
                result.append(current);
            }
        }
        return result.toString();
    }
    public static void main( String[] args ) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello World!");
        strings.add("tree");
        strings.add("cccaaa");
        strings.add("Aabb");


        for ( String string : strings ) {
            System.out.println("\nInput: s = " + string +
                "\nOutput: " + frequencySort(string));
        }
    }
}
