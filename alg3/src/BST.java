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
        return get(root, key) != null;
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

    private Node put(Node r, Key key, Value value){
        if(r == null){
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(r.key);
        if(compare < 0){
            r.left = put(r.left, key, value);
        }
        else if(compare > 0){
            r.right= put(r.right, key, value);
        }
        else {
            r.value = value;
        }
        r.size = 1 + size(r.left) + size(r.right);
        return r;
    }


}
