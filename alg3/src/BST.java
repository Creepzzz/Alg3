
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    /**
     * Class of node
     */
    public class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;

        /**
         * Constructor of node with following attributes
         * @param key    is object assigned to node
         * @param value  is value paired with the node
         * @param size   is the number of nodes in sub-tree
         */
        public Node(Key key, Value value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    /**
     * Constructor of binary search tree
     */
    public BST(){
    }

    /**
     *
     * @return true if the size of the sub-tree of root is empty
     * (which means the whole tree is empty)
     */
    public boolean isEmpty(){
        return size(root) == 0;
    }

    /**
     *
     * @return the size of the sub-tree under the root
     * (which is the whole tree)
     */
    public int size(){
        return size(root);
    }

    /**
     *
     * @param n is node we want to know the size of the sub-tree of
     * @return the size of the sub-tree of the node
     */
    private int size(Node n){
        if(n == null) return 0;
        else return n.size;
    }

    /**
     * Checks if the key exists in the tree
     * @param key is object we want to check
     * @return true if the key exists in the tree
     */
    public boolean contains(Key key){
        if(key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }

    /**
     * Takes in a key and sends it to the other getter
     * function together with the root-node in order
     * to check for the key in the whole tree
     * @param key is object we want the value for
     * @return the value paired with the key
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * Searches for the node with given key, comparing
     * the given key with the key of the current node.
     * If the value is smaller, we move to the left in the tree.
     * If the value is greater, we move to the right.
     * The method works recursively until the the right
     * node if found.
     * @param n is the node we start the comparison from
     * @param key is the object we want the value pair for
     * @return the value paired with given key
     */
    public Value get(Node n, Key key){
        if(key == null) throw new IllegalArgumentException();
        if(n == null) return null;
        int compare = key.compareTo(n.key);
        if(compare < 0)
            return get(n.left, key);
        else if(compare > 0)
            return get(n.right, key);
        else
            return n.value;
    }

    /**
     * Takes in a key and a value and sends it to the
     * other put function together with the root-node
     * in order to search through the whole tree for the
     * right place of the new node.
     * @param key   is object to put into the three
     * @param value is the value paired with the key
     */
    public void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException();
        if(value == null) return;
        root = put(root, key, value);
    }

    /**
     * Takes in a key, value and a node, compares the key with
     * the key of current node. If the current node is null, we create
     * a new node and assign the new node with the key and value.
     * If the key is smaller than the key assigned to the node, we move
     * to the left in the tree. If the key is larger than the ley of the
     * current node, we move to the right in the tree.
     * Once the right node if found, the value is tied to the node and the
     * size of that node is increased with 1 and the size of possible
     * children of the node.
     * @param n      is the current node
     * @param key    is the object we compare with in order to find the right node
     * @param value  is the value we want to want to put into the wanted node
     * @return       the right node which has a new key, value and size
     */
    private Node put(Node n, Key key, Value value){
        if(n == null) return new Node(key, value, 1);
        int compare = key.compareTo(n.key);
        if(compare < 0) n.left = put(n.left, key, value);
        else if(compare > 0) n.right= put(n.right, key, value);
        else n.value = value;
        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }
}
