import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int size = 0;
    private static final int CAPACITY = 2;

    public BinarySearchST(){
        this(CAPACITY);
    }

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void put(Key key, Value value){
        if(key == null){
            throw new IllegalArgumentException();
        }

        if(value == null){
            delete(key);
            return;
        }

        //Check if key is in tale
        int i = rank(key);
        if((i < size) && (keys[i].compareTo(key)==0)){
            values[i] = value;
            return;
        }

        if(size == keys.length){
            resize(2* keys.length);
        }

        for(int j = size; j > i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public void delete(Key key){
        if(key == null){
            throw new IllegalArgumentException();
        }
        int i = rank(key);

        if(i == size || keys[i].compareTo(key)!=0 || isEmpty()){
            return;
        }

        for(int j = i; j < size-1; j++){
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }

        size--;
        keys[size] = null;
        values[size] = null;

        if(size > 0 && size == keys.length/4){
            resize(keys.length/2);
        }
    }

    public int rank(Key key){
        if(key == null){
            throw new IllegalArgumentException();
        }

        int lo = 0;
        int hi = size-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            int compare = key.compareTo(keys[mid]);
            if(compare < 0){
                hi = mid-1;
            }
            else if(compare > 0){
                lo = mid+1;
            }
            else return mid;
        }
        return lo;
    }

    private void resize(int n){
        Key[] tempk = (Key[]) new Comparable[n];
        Value[] tempv = (Value[]) new Object[n];

        for(int i = 0; i < size; i++){
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        keys = tempk;
        values = tempv;
    }

    public boolean contains(Key key){
        if(key == null){
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    }

    public Value get(Key key){
        if(key == null){
            throw new IllegalArgumentException();
        }
        if(isEmpty()){
            return null;
        }
        int i = rank(key);
        if(i < size && keys[i].compareTo(key)==0){
            return values[i];
        }
        return null;
    }

}
