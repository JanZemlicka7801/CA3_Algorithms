package part3;

import utils.StringUtilities;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jan_zemlicka
 */
public class Part3MergeAndPartition {
    /**
    * The Main class contains the main method for user interaction and demonstrates the usage
    * of methods from the StringUtilities class.
    */
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        // Declare variables for array sizes and initialize arrays
        var input = 0;
        var input2 = 0;
        String[] array = new String[input];
        String[] array2 = new String[input2];
        String[] mergedArray = new String[0];

        // Ask the user to specify how many words they will enter and use it to create an array.
        System.out.println("How many words you will enter ?");
        input = sc.nextInt();

        // Repeatedly ask the user to enter a word and store it in the first array.
        for (int i = 0; i < input; i++){
            System.out.println("Enter a word");
            String word = sc.next();
            array[i] = word;
        }
        // Display the array contents to the user
        System.out.println(Arrays.toString(array));

        // Ask if they wish to create a second array of words
        System.out.println("Do you wish to create a second array of words ?");
        String answer = sc.next();

        // If the user wants to create a second array:
        // Repeat steps a through c for the second array
        // Merge all contents of the new array with all contents of the original one
        // Display the merged array
        if(answer.equalsIgnoreCase("yes")){
            System.out.println("Enter how many words you would like to enter");
            input2 = sc.nextInt();

            // Repeatedly ask the user to enter a word and store it in the second array.
            for(int i = 0; i < input2; i++){
                System.out.println("Enter a word to second array");
                String word = sc.next();
                array2[i] = word;
            }

            // Display the contents of the second array to the user
            System.out.println(Arrays.toString(array2));
            // Merge the two arrays using the StringUtilities.merge() method
            mergedArray = utils.StringUtilities.merge(array, array2, array.length, array2.length);
            // Display the merged array to the user
            System.out.println(Arrays.toString(mergedArray));
        }

        // Ask the user to enter a word to function as the pivot for partitioning.
        System.out.println("Please provide a pivot word for partitioning.");
        String pivot =  sc.next();

        // Partition the first array based on the supplied word using StringUtilities.partition() method
        StringUtilities.partition(array, pivot);

        // If a second array was created, partition the merged array
        if (answer.equalsIgnoreCase("Yes")){
            StringUtilities.partition(mergedArray, pivot);
        }

        // Display the new version of the merged array (including its position information).
        System.out.println("Array with possition information");
        for (int i = 0; i < mergedArray.length; i++){
            System.out.println("Possition " + i + " : " + mergedArray[i] + "\n");
        }
    }
}
