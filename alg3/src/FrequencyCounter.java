import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {

    public static int distinct = 0;
    public static int distinct2 = 0;
    public static int N = 5;
    public static int numberOfWords = 0;
    public static int numberOfWords2 = 0;
    public static int pos = 0;
    public static int pos2 = 0;
    public static String[] input = new String[N *100];


    private FrequencyCounter() {
    }
    private static long BSSTTime() throws FileNotFoundException {

        BinarySearchST<String, Integer> st = new BinarySearchST<>();
        File myFile = new File("C:\\Users\\matil\\source\\repos\\Alg3\\Alg3\\destAlg3.txt");
        Scanner scanner = new Scanner(myFile);

        long time1 = System.nanoTime();
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
        String max = "";
        st.put(max, 0);
        for(int i = 0; i < pos; i++){
            String key = input[i];
            if(st.get(key) > st.get(max)){
                max = key;
            }
        }
        time1 = System.nanoTime()-time1;
        System.out.println("Most freq word: " + max + " \nNumber of times: " + st.get(max));
        System.out.println("Number of distinct words: " + distinct);
        System.out.println("Total number of words: " + numberOfWords);
        return time1;
    }

    private static long BSTTime() throws FileNotFoundException {
        BST<String, Integer> bst = new BST<>();
        long time2 = System.nanoTime();
        File myFile = new File("C:\\Users\\matil\\source\\repos\\Alg3\\Alg3\\destAlg3.txt");
        Scanner scanner = new Scanner(myFile);

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
        String max = "";
        bst.put(max, 0);
        for(int i = 0; i < pos2; i++){
            String key = input[i];
            if(bst.get(key) > bst.get(max)){
                max = key;
            }
        }
        time2 = System.nanoTime()-time2;
        System.out.println("Most freq word: " + max + " \nNumber of times: " + bst.get(max));
        System.out.println("Number of distinct words: " + distinct2);
        System.out.println("Total number of words: " + numberOfWords2);

        return time2;
    }

    public static void main(String[]args) throws FileNotFoundException {
        long time1 = BSSTTime();
        System.out.println(time1);
        long time2 = BSTTime();
        System.out.println(time2);
    }
}
