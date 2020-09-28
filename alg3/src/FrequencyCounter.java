/*
Author: Matilda Qvick 001105-0606
Generated: 21/9 - 2020
Last updated: 28/9 - 2020
Solves: Calculates the time for built and search for
        both binary search symbol table and binary search tree.
        The most frequent word is displayed as well as the number
        of times that word is used. It also displays the number
        of distinct words and the total number of words.
How to use: The most frequent word, the number
            that words has been used, the number of distinct words,
            the total number of words and the build and search execution
            time for both the tree and symbol table will be displayed.

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {

    public static int distinct = 0;
    public static int distinct2 = 0;
    public static int N = 1;
    public static int numberOfWords = 0;
    public static int numberOfWords2 = 0;
    public static int pos = 0;
    public static int pos2 = 0;
    public static String[] input = new String[N *100];
    public static long timeBSSTBuild;
    public static long timeBSSTSearch;
    public static long timeBSTBuild;
    public static long timeBSTSearch;


    /**
     * Constructor
     */
    private FrequencyCounter() {
    }

    /**
     * Creates an instance of BinarySearchST and puts the words from
     * the given file into the symbol table. If the word already exists
     * the value of it is increased, otherwise the number of distinct words
     * are calculated.
     * The most used word is also searched and displayed.
     * The time of the build and search is calculated
     * @throws FileNotFoundException
     */
    private static void BSSTTime() throws FileNotFoundException {
        BinarySearchST<String, Integer> st = new BinarySearchST<>();
        File myFile = new File("C:\\Users\\matil\\source\\repos\\Alg3\\Alg3\\destAlg3.txt");
        Scanner scanner = new Scanner(myFile);

        timeBSSTBuild = System.nanoTime();
        while (scanner.hasNext() && numberOfWords < N*100){
            String key = scanner.next();
            numberOfWords++;
            if(st.contains(key)){
                st.put(key, st.get(key)+1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
            input[pos] = key;
            pos++;
        }
        timeBSSTBuild = System.nanoTime()-timeBSSTBuild;
        String max = "";
        st.put(max, 0);

        for(int i = 0; i < pos; i++){
            String key = input[i];
            if(st.get(key) > st.get(max)){
                max = key;
            }
        }

        String key = "set";
        timeBSSTSearch = System.nanoTime();
        for (String word: st.keys()){
            if(st.get(word).equals(key)){
                return;
            }
        }
        timeBSSTSearch = System.nanoTime()-timeBSSTSearch;
        System.out.println("Most freq word: " + max + " \nNumber of times: " + st.get(max));
        System.out.println("Number of distinct words: " + distinct);
        System.out.println("Total number of words: " + numberOfWords);
    }

    /**
     * Creates an instance of BST and puts every word from the
     * given file into the tree. If the word already exists, it's
     * value is increased, otherwise new word is assigned a new node
     * and the number of distinct words are increased.
     * The most frequently used word is searched for and displayed
     * a long side with the number of words and the number of distinct
     * words.
     * The time for build and search is calculated
     * @throws FileNotFoundException
     */
    private static void BSTTime() throws FileNotFoundException {
        BST<String, Integer> bst = new BST<>();
        File myFile = new File("C:\\Users\\matil\\source\\repos\\Alg3\\Alg3\\destAlg3.txt");
        Scanner scanner = new Scanner(myFile);

        timeBSTBuild = System.nanoTime();
        while (scanner.hasNext() && numberOfWords2 < N*100){
            String key = scanner.next();
            numberOfWords2++;
            if(bst.contains(key)){
                bst.put(key, bst.get(key)+1);
            }
            else {
                bst.put(key, 1);
                distinct2++;
            }
            input[pos2] = key;
            pos2++;
        }
        timeBSTBuild = System.nanoTime()-timeBSTBuild;
        String max = "";
        bst.put(max, 0);

        for(int i = 0; i < pos2; i++){
            String key = input[i];
            if(bst.get(key) > bst.get(max)){
                max = key;
            }
        }

        String key = "set";
        timeBSTSearch = System.nanoTime();
        for(String word: bst.keys()){
            if(bst.get(word).equals(key)){
                return;
            }
        }
        timeBSTSearch = System.nanoTime()-timeBSTSearch;
        System.out.println("Most freq word: " + max + " \nNumber of times: " + bst.get(max));
        System.out.println("Number of distinct words: " + distinct2);
        System.out.println("Total number of words: " + numberOfWords2);
    }

    /**
     * Displays the most frequent word, how many times the word occurred,
     * the number of distinct words as well as the total number of words.
     * These values would be the same for both algorithms.
     * The execution time for the two is also displayed, this value should
     * be the same for both algorithms.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[]args) throws FileNotFoundException {
        System.out.println("\nBINARY SEARCH SYMBOL TABLE");
        BSSTTime();
        System.out.println("Build time: " + timeBSSTBuild);
        System.out.println("Search time: "+ timeBSSTSearch);
        System.out.println("\nBINARY SEARCH TREE");
        BSTTime();
        System.out.println("Build time: " + timeBSTBuild);
        System.out.println("Search time: " + timeBSTSearch);
    }
}
