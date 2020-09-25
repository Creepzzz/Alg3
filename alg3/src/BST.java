import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    public class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;


        public Node(Key key, Value value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }

    }

    public BST(){

    }

    public boolean isEmpty(){
        return size(root) == 0;
    }
    public int size(){
        return size(root);
    }

    private int size(Node n){
        if(n == null){
            return 0;
        }
        else {
            return n.size;
        }
    }

    public boolean contains(Key key){
        if(key == null){
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node n, Key key){
        if(key == null){
            throw new IllegalArgumentException();
        }
        if(n == null){
            return null;
        }
        int compare = key.compareTo(n.key);
        if(compare < 0){
            return get(n.left, key);
        }
        else if(compare > 0){
            return get(n.right, key);
        }
        else {
            return n.value;
        }
    }

    public void put(Key key, Value value){
        if(key == null){
            throw new IllegalArgumentException();
        }
        if(value == null) {
            return;
        }

        root = put(root, key, value);
    }

    private Node put(Node n, Key key, Value value){
        if(n == null){
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(n.key);
        if(compare < 0){
            n.left = put(n.left, key, value);
        }
        else if(compare > 0){
            n.right= put(n.right, key, value);
        }
        else {
            n.value = value;
        }
        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }

    public static void main(String[]args) throws FileNotFoundException {
        BST<String, Integer> bst = new BST<>();
        File myFile = new File("C:\\Users\\matil\\source\\repos\\Alg3\\Alg3\\alg3.5.txt");
        Scanner scanner = new Scanner(myFile);
        while(scanner.hasNext()){
            String s = scanner.next();
            System.out.print(s);
            bst.put(s, (int)s.charAt(0));
            System.out.println(bst.get(s));
        }

        int i = 65;
           while (i < 88){
            while (bst.get(Character.toString((char) i)) == null || i > 88) {
                i++;
            }
            int n = bst.get(Character.toString((char) i));
            System.out.print((char) n);
            i++;
        }
    }

}
