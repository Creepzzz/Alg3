import java.util.NoSuchElementException;

public class SequentialSearchST<Key, Value> {
    private int numberOfPairs;
    private Node first;

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    SequentialSearchST(){
    }

    public boolean isEmpty(){
        return numberOfPairs==0;
    }

    private int size(){
        return numberOfPairs;
    }

    public boolean contains(Key key){
        return get(key)!= null;
    }

    public Value get(Key key){
        for(Node n = first; n != null; n = n.next){
            if(key.equals(n.key))
                return n.value;
        }
        return null;
    }

    public void put(Key key, Value value){
        if(value == null) return;
        for(Node n = first; n != null; n = n.next){
            if(key.equals(n.key)){
                n.value = value;
                return;
            }
        }
        first = new  Node(key, value, first);
        numberOfPairs++;
    }



}

