import java.util.Objects;
import java.util.Scanner;

public class HashTable<Key, Value> {
/*    private static final int CAPACITY = 141492;
    private static int numberOfChains;
    private static int size;



    public HashTable(){
        this(CAPACITY);
    }

    public HashTable(int numberOfChains){
        this.numberOfChains = numberOfChains;
        s = (HashTableQ<Key, Value>[]) new HashTableQ[numberOfChains];
        for(int i = 0; i < numberOfChains; i++){
            s[i] = new HashTableQ<Key, Value>();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff)% numberOfChains;
    }

    public boolean contains(Key key){
        if(key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException();
        int i = hash(key);
        return s[i].get(key);
    }

    public void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException();
        if(value == null) return;
        int i = hash(key);
        if(!s[i].contains(key)) size++;
        s[i].put(key, value);
    }


    public static void main(String[]args){
        String[] text = new String[1000];
        HashTable<Integer, String> hashTable = new HashTable<>();
        BinarySearchST<Integer, String> binST = new BinarySearchST<>();
        int numberOfWords = 0;
        int pos = 0;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext() && numberOfWords < 10){
            String key = scanner.next();
            numberOfWords++;
            hashTable.put(hashTable.hash(key.hashCode()), key);
            //binST.put(hashTable.hash(key), key);
            text[pos++] = key;
        }
        for(int i = 0; i < pos; i++){
            System.out.println(i + " " + binST.get(i));
        }
    }*/
}
