import java.util.ArrayList;
import java.lang.Math;
import java.util.TreeMap;

/**
 * @author Aurko
 * Convert a non-negative integer 'num' to its respective English word representation.
 */
public class IntegerToEnglish {
    public static void main ( String[] args ) {
        int testSize = 10;  // test sample size
        int min = 1;        // minimum constraint
        int max = (int)Math.pow(2,31);     // maximum constraint

        ArrayList<Integer> testData = generateRandomInts( testSize, min, max ); // generate test values

        System.out.println( getResults(testData) ); // print the results
    }

    /**
     * TODO: PERHAPS I CAN USE THE SAME APPROACH AS I DID WITH THE INTEGER TO ROMANS AND UTILIZE THE TREEMAP
     * @param num
     * @return
     */
    public static String numberToWords(int num) {
        String result = "";
        if( num == 0 ) {
            return treemap.get(0);
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
    private static ArrayList<Integer> generateRandomInts(int size, int min, int max) {
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
                    " \tRoman Numberal:\t" + numberToWords(number) );
        }

        return results;
    }

    private static final TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
    static {
        treemap.put(0, "Zero");
        treemap.put(1, "One");
        treemap.put(2, "Two");
        treemap.put(3, "Three");
        treemap.put(4, "Four");
        treemap.put(5, "Five");
        treemap.put(6, "Six");
        treemap.put(7, "Seven");
        treemap.put(8, "Eight");
        treemap.put(9, "Nine");
        treemap.put(10, "Ten");
        treemap.put(11, "Eleven");
        treemap.put(12, "Twelve");
        treemap.put(13, "Thirteen");
        treemap.put(14, "Fourteen");
        treemap.put(15, "Fifteen");
        treemap.put(16, "Sixteen");
        treemap.put(17, "Seventeen");
        treemap.put(18, "Eighteen");
        treemap.put(19, "Nineteen");
        treemap.put(20, "Twenty");
        treemap.put(30, "Thirty");
        treemap.put(40, "Forty");
        treemap.put(50, "Fifty");
        treemap.put(60, "Sixty");
        treemap.put(70, "Seventy");
        treemap.put(80, "Eighty");
        treemap.put(90, "Ninety");
    }
}

