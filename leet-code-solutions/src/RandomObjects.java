import java.util.ArrayList;
import java.util.Random;

public class RandomObjects {
    private static final String alphabet = "abcdefghijklmnopqrstubwxyz";
    private static final String specialChars = "!@#$%^&*()-=_+,./<>?;':\"[]{}|"; // Todo: implement these later.
    Random random;

    /**
     * Default Constructor
     */
    public RandomObjects() {
        random = new Random();
    }

    /**
     * generate a random integer within a certain range
     * @param min minimum range
     * @param max maximum range
     * @return a random integer
     */
    public int generateRandomInt( int min, int max ) {
        return   random.nextInt(max - min) + min;
    }

    /**
     * Generate a collection of random integers
     * @param size how many random integers to create
     * @param min minimum range
     * @param max maximum range
     * @return a collection of random integers
     */
    public ArrayList<Integer> generateRandomInts( int size, int min, int max ) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for ( int i = 0; i < size; i++ ) {
            testData.add(generateRandomInt( min, max ));
        }
        return testData;
    }

    /**
     * Generate a random Double
     * @param min minimum range
     * @param max maximum range
     * @return a random double
     */
    public double generateRandomDouble( double min, double max ) {
        return min + (max - min) * random.nextDouble();
    }

    /**
     * Generate a random collection of Doubles
     * @param size how many random Doubles to create
     * @param min minimum range
     * @param max maximum range
     * @return a collection of random doubles
     */
    public ArrayList<Double> generateRandomDoubles( int size, double min, double max ) {
        ArrayList<Double> testData = new ArrayList<Double>();

        for ( int i = 0; i < size; i++ ) {
            testData.add(generateRandomDouble(min, max));
        }
        return testData;
    }

    /**
     * Generate a random character from the alphabet
     * TODO I'll need to implement a system to handle alphabets vs special characters vs both in the future.
     * @return a random character
     */
    public char generateRandomChar() {
        return generateRandomCharFromRange('a', 'z');
    }

    /**
     *
     * @param size
     * @return
     */
    public ArrayList<Character> generateRandomChars( int size ) {
        return generateRandomCharsFromRange( size, 'a', 'z');
    }

    /**
     *
     * @param min
     * @param max
     * @return
     */
    public char generateRandomCharFromRange( char min, char max ) {
        min = Character.toLowerCase(min);
        max = Character.toLowerCase(max);
        return alphabet.charAt(generateRandomInt(alphabet.indexOf(min), alphabet.indexOf(max)));
    }

    /**
     *
     * @param size
     * @param min
     * @param max
     * @return
     */
    public ArrayList<Character> generateRandomCharsFromRange( int size, char min, char max ) {
        ArrayList<Character> testData = new ArrayList<Character>();

        for ( int i = 0; i < size; i++ ) {
            testData.add(generateRandomCharFromRange(min, max));
        }
        return testData;
    }

    /**
     *
     * @param min
     * @param max
     * @return
     */
    public char generateRandomCaseCharFromRange( char min, char max ) {
        if(generateRandomBoolean()) {
            return Character.toUpperCase(generateRandomCharFromRange(min, max));
        }
        return generateRandomCharFromRange(min, max);
    }

    /**
     *
     * @return
     */
    public char generateRandomCaseChar() {
        return generateRandomCaseCharFromRange('a', 'z');
    }

    /**
     *
     * @param size
     * @param min
     * @param max
     * @return
     */
    public ArrayList<Character> generateRandomCaseCharFromRange( int size, char min, char max ) {
        ArrayList<Character> testData = new ArrayList<Character>();
        for ( int i = 0; i < size; i++ ) {
            testData.add(generateRandomCaseCharFromRange('a', 'z'));
        }
        return testData;
    }

    /**
     * @return a coin flip
     */
    public boolean generateRandomBoolean() {
        return random.nextBoolean();
    }

    /**
     * Collection of random binary probabilities
     * @param size
     * @return
     */
    public ArrayList<Boolean> generateRandomBooleans( int size ) {
        ArrayList<Boolean> testData = new ArrayList<Boolean>();
        for ( int i = 0; i < size; i++ ) {
            testData.add(generateRandomBoolean());
        }
        return testData;
    }

    public static void main( String[] args ) {
        RandomObjects random = new RandomObjects();

        //TODO: if I'm bored, write some tests/demos here
        /** Demo 1: generateRandomInt() */
        System.out.println("Test generateRandomInt(0,10): " + random.generateRandomInt(0,10));

        /** Demo 2: generateRandomDouble() */
        System.out.println(("Test generateRandomDouble(-10.0,10.0): " + random.generateRandomDouble(-5, 5)));

        /** Demo 3:*/

        /** Demo 4:*/

        /** Demo 5:*/

        /** Demo 6:*/

        /** Demo 7:*/

        /** Demo 8:*/

        /** Demo 9:*/

        /** Demo 10:*/

        /** Demo 11:*/

        /** Demo 12:*/

        /** Demo 13:*/

        /** Demo 14:*/

        /** Demo 15:*/

        /** Demo 16:*/

        /** Demo 17:*/

    }
}
