/**
 * @author Aurko
 * @description Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *      You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *      You can return the answer in any order.
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  Given an array of integers 'nums' and an integer 'target', return indexes
 *      of the two numbers such that they add up to 'target'
 */
public class TwoSum {
    private static ArrayList<int[]> testData = new ArrayList<>();   // Used to hold the test samples

    /**
     * SUBMISSION A - I thought I was being clever here and saving some efficiency by sorting the array
     *      and then comparing the first and last values; however it will return the incorrect indexes due to the sort
     *      maybe there is something I can tinker with here to make it work, but it seems redundant if I am going to
     *      search for the index in the original array based on the value. Had, the problem just required me to
     *      print the values instead of the indexes, this solution would have been ideal.
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum_obsolete(int[] nums, int target) {
        Arrays.sort( nums );
        int small = 0;
        int large = nums.length - 1;
        while( small < large ) {
            if ( nums[small] + nums[large] == target) {
                return new int[] { small, large};
            } else if ( nums[small] + nums[large] < target ) {
                small++;
            } else {
                large--;
            }
        }
        return new int[] {};
    }

    /**
     * SUBMISSION B - A much better approach to Solution A, as we parse through the Array, add the value as the
     *      key to the HashMap, this makes it faster to search for the index later on.
     *      Check if the (target - current number) already exists in the map
     *          if it does exist return the value's respective key
     *          Otherwise just add the current value and its respective index to the hashmap and try again
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        Map values = new HashMap();     //create new HashMap
        for (int i = 0; i < numbers.length; i++) {
            int j = target - numbers[i];    // search key is target minus the value of index
            if (values.containsKey(j))      // if my hashmap contains the key return that index
                return new int[] { (int)values.get(j), i };
            values.put(numbers[i], i);  //put value and index into hashmap
        }
        return null;
    }

    public static void main( String args []) {
        int[] num1 = {2,7,11,15};   // target 9
        int[] num2 = {3,2,4};       // target 6
        int[] num3 = {3,3};         // target 6
        testData.add(num1);
        testData.add(num2);
        testData.add(num3);
        if (args.length > 0) {
            System.out.println("No input taken!");
        }
        ArrayList<int[]> results = new ArrayList<>();
        results.add(twoSum(num1, 9));
        results.add(twoSum(num2, 6));
        results.add(twoSum(num3, 6));

        int n = 1; // Serialized
        for( int[] result : results) {
            if( result.length == 2) {
                System.out.println("Test " + n++ + ": [" +
                        result[0] + "," +  result[1] + "]");
            }
        }   // Todo: add a cleaner way to handle the string outputs
    }
}
