import java.util.ArrayList;
public class Solution {
    public static void main( String[] args) {
        if (args.length < 0) {  //TODO: I'll do this when I run tests off a unix terminal more often.
            System.out.println("Program does not currently support parameters");
            return;
        }

        ArrayList<String> testData = new ArrayList<>();   // Used to hold the test samples
        testData.add("III");
        testData.add("LVIII");
        testData.add("MCMXCIV");    //TODO:  it might be cool to have a random roman numeral generator function

        ArrayList<String> results = calculateResults(testData);

        for ( String result : results ) {
            System.out.println(result);
        }
    }

    /**
     * This method just takes an array list of test values and returns the results in an array list
     *      in the future I may add implementations for writing to a file or csv. It would be easier to just have
     *      a method that returns the String value for each result.
     * @param testData
     * @return
     */
    private static ArrayList<String> calculateResults( ArrayList<String> testData) {
        ArrayList<String> results = new ArrayList<>();
        for ( String data : testData ) {
            results.add("Roman Numeral:\t" + data +
                    "\nInteger:\t" + romanToInt(data));
        }
        return results;
    }

    /**
     * Convert a Roman Numeral String to the respective integer value
     * @param s Roman Numeral String
     * @return integer value of the Roman Numeral
     */
    private static int romanToInt(String s) {
        int n = s.length();
        int value = 0 ;
        int current;
        int next;
        int i = 0;
        while(i < n) {
            if( i == n - 1 ) {
                value += getValueOfChar(s.charAt(i));
                return value;
            }

            current = getValueOfChar(s.charAt(i));
            next = getValueOfChar(s.charAt(i + 1));

            if( current >= next ) {
                value += current;
                i++;
            }
            else {
                value += next - current;
                i += 2;
            }
        }
        return value;
    }

    /**
     * Determine the integer value of a roman numeral character
     * @param c roman numeral
     * @return integer value of roman numeral
     */
    private static int getValueOfChar(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default: return 0;
        }
    }
}
