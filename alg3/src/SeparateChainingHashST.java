import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeparateChainingHashST<Key, Value> {
    private static final int CAPACITY = 4;
    private int numberOfPairs;
    private int size;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST(){
        this(CAPACITY);
    }

    public SeparateChainingHashST(int size){
        this.size = size;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[size];
        for(int i = 0; i < size; i++){
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private void resize(int numberOfChains){
        SeparateChainingHashST<Key, Value> tempST = new SeparateChainingHashST<Key, Value>(numberOfChains);
        for(int i = 0; i < size; i++){
            //not done
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public boolean contains(Key key){
        if(key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException();
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException();
        if(value == null) return;;
        //removed resize
        int i = hash(key);
        if(!st[i].contains(key))
            numberOfPairs++;
        st[i].put(key, value);
    }

    public static void main(String[]args) throws FileNotFoundException {
        SeparateChainingHashST<Integer, Integer> myST = new SeparateChainingHashST<>();
        BinarySearchST<Integer, Integer> myST2 = new BinarySearchST<>();
        Integer[] input = new Integer[141492];
        File myFile = new File("C:\\Users\\matil\\source\\repos\\Alg3\\Alg3\\destAlg3.txt");
        int numberOfWords = 0;
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()){
            int key = scanner.next().hashCode();
            numberOfWords++;
            if(myST2.contains(key)){
               myST.put(key, numberOfWords);
               myST2.put(key, myST.hash(key)+1);
            }
            input[numberOfWords] = key;
        }
        for(int i = 1; i < numberOfWords; i++){
            System.out.println(i + " " + myST2.get(input[i]));
        }



    }
}
