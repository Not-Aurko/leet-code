import java.util.ArrayList;
public class Solution {
    public static void main( String args[]) {

    }

    private int romanToInt(String s) {
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

    private int getValueOfChar(char c) {
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
