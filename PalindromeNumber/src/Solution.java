import java.util.ArrayList;

public class Solution {
    private static boolean isPalindrome( int x ) {
        char[] checkInt  = String.valueOf(x).toCharArray();
        int i = 0;  // Variable to rerpresent begining of the array
        int j =  checkInt.length - 1; // Variable to represent the end of the array
        while ( i < j ) {
            if (checkInt[i] != checkInt[j] ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main( String[] args ) {
        int[] testInts = new int[] {121, -121, 344};
        for ( int number : testInts) {
            System.out.println( number + "\'s palindrome status: " + isPalindrome(number) );
        }
    }
}
