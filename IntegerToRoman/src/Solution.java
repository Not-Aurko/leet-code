import java.util.ArrayList;
import java.util.TreeMap;

/**
 * This was a fun project and helped me better understand recursive searches through self balanced trees using
 *  Java's TreeMap
 */
public class Solution {
    public static void main ( String[] args ) {
        int testSize = 10;  // test sample size
        int min = 1;        // minimum constraint
        int max = 3999;     // maximum constraint

        ArrayList<Integer> testData = generateRandomInts( testSize, min, max ); // generate test values

        System.out.println( getResults(testData) ); // print the results
    }

    /**
     * Get the greatest possible number, which is less than or equal to our given paramater
     *      if the value is equal to the number, return the resulting Roman value
     *      otherwise return the greatest possible roman numeral and call the function again after
     *          subtracting the integer value;
     * @param num   integer number
     * @return  if the number is equal to a value in the roman numeral map, return the roman numeral
     *              otherwise append the highest possible roman numeral and call the function again.
     */
    private static String intToRoman( int num ) {
        int i = treemap.floorKey(num);
        if(num == i) {
            return treemap.get(num);
        }
        return treemap.get(i) + intToRoman( num - i );
    }

    /**
     * Initial Approach --
     * Loop through the arrays of the Roman Numerals to
     *      get the highest possible roman numeral value that is less than or equal to the parameter
     *      append the string and subtract the respective integer amount from the number until we hit zero.
     * @param num integer value used to determine the roman numeral version
     * @return  String containing the correct roman numeral.
     */
    private static String intoToRoman_old( int num ) {
        String result = "";
        int i = romanLiterals.length - 1; // used to parse through array

        while ( num > 0) {
            while (romanValues[i] <= num) {
                result += romanLiterals[i];
                num -= romanValues[i];
            }
            i--;
        }
        return result;
    }

    /**
     * This is a helper function designated to creating random integer numbers
     * @param size int value to represent total number of ints to return
     * @param min minimum integer range
     * @param max maximum integer range
     * @return  an ArrayList of integer values
     */
    private static ArrayList<Integer> generateRandomInts( int size, int min, int max) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for ( int i = 0; i < size; i++ ) {
            testData.add((int)Math.floor(Math.random()*(max-min+1)+min));
        }
        return testData;
    }

    /**
     * This is a helper function that neatly puts the test results into an array list of strings
     * @param testData  sample test data
     * @return the results oif intToRoman in an ArrayList of Strings
     */
    private static ArrayList<String> getResults( ArrayList<Integer> testData ) {
        ArrayList<String> results = new ArrayList<String>();
        for( int number : testData ) {
            results.add("\nInt:\t" + number +
                " \tRoman Numberal:\t" + intToRoman(number) );
        }

        return results;
    }

    /**
     * Create a TreeMap to hold all possible Roman Numeral Values based on the respective integer Key.
     * Use the integer value as the ke and its Roman Numeral representation as the value
     * Tree map will store the elements in the natural ordering of keys
     */
    private static final TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
    static {
        treemap.put(1, "I");
        treemap.put(4, "IV");
        treemap.put(5, "V");
        treemap.put(9, "IX");
        treemap.put(10, "X");
        treemap.put(40, "XL");
        treemap.put(50, "L");
        treemap.put(90, "XC");
        treemap.put(100, "C");
        treemap.put(400, "CD");
        treemap.put(500, "D");
        treemap.put(900, "CM");
        treemap.put(1000, "M");
    }

    // Store both numbers and roman numerals in an array in ascending order
    private static final int[] romanValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] romanLiterals = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
}
