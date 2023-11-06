package utils;

/**
 *
 * @author jan_zemlicka
 */
public class StringUtilities {
    /**
     * Merges two String arrays up to specified positions and returns the merged array.
     *
     * @param array1 The first String array to be merged.
     * @param array2 The second String array to be merged.
     * @param one The position up to which elements from array1 will be merged.
     * @param two The position up to which elements from array2 will be merged.
     * @return The merged String array containing elements from array1 and array2.
     */
    public static String[] merge(String[] array1, String[] array2, int one, int two){
        // Check if the specified positions are within the bounds of the input arrays
        if(one > array1.length){
            one = array1.length;
        }
        if(two > array2.length){
            two = array2.length;
        }

        // Create a new array to store merged elements
        String[] mergedArray = new String[one + two];

        // Copy elements from the first array up to position 'one'
        for( int i = 0; i < one; i++){
            mergedArray[i] = array1[i];
        }

        // Copy elements from the second array up to position 'two'
        for(int i = 0; i < two; i++){
            mergedArray[one+i] = array2[i];
        }

        // Return the merged array
        return mergedArray;
    }
    /**
     * Partitions a String array into two sub-arrays based on a pivot word.
     * Elements greater than the pivot word are placed in one sub-array,
     * and elements less than or equal to the pivot word are placed in another sub-array.
     *
     * @param array The String array to be partitioned.
     * @param pivot The word used as the pivot for partitioning.
     * @return The merged and partitioned String array.
     */

    public static String[] partition(String[] array, String pivot){
        // Create two arrays to store elements greater and less than the pivot
        String[] arrayLess = new String[array.length];
        String[] arrayMore = new String[array.length];

        // Counters for positions in the two arrays
        int lessCounter = 0;
        int moreCounter = 0;

        // Iterate through the input array and partition elements based on the pivot
        for (String word : array){
            if(word.compareToIgnoreCase(pivot)>0){
                arrayMore[moreCounter] = word;
                moreCounter++;
            } else {
                arrayLess[lessCounter] = word;
                lessCounter++;
            }
        }

        // Merge the two partitioned arrays and return the result
        return merge(arrayMore, arrayLess, moreCounter, lessCounter);
    }
    /**
     * Counts the number of occurrences of a specific word in a String array.
     *
     * @param array The String array in which to count occurrences.
     * @param word The word to be counted.
     * @return The number of occurrences of the specified word in the array.
     */

    public static int count(String[] array, String word){
        int repeatNumber = 0;
        // Iterate through the array and count occurrences of the specified word
        for(String piece : array) {
            if(piece.equalsIgnoreCase(word)){
                repeatNumber++;
            }
        }
        // Return the count of occurrences
        return repeatNumber;
    }
}
