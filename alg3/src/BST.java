/*
Author: Matilda Qvick 001105-0606
Generated: 21/9 - 2020
Last updated: 28/9 - 2020
Solves: Creates a binary search table with a root
        and subtrees. The tree has nodes with a key-value
        pair as well as a size. The size of a node is the
        size of teh subtree underneath it.
        The class uses an Iterable which creates an instance
        of class SortQueue, this will create a queue
        of all key-value pairs to iterate through.
How to use: This class is only used in FrequencyCounter
 */

import java.util.NoSuchElementException;

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
        assert check();
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


    /**
     * Constructor of Iterable of all keys
     * @return a queue of all keys in the tree
     */
    public Iterable<Key> keys(){
        if(isEmpty()) return new SortQueue<Key>();
        return keys(min(), max());
    }

    /**
     * Constructor of Iterable of all keys in symbol
     * table from given range
     * @param lo is lowest index
     * @param hi is highest index
     * @return an iterable of all keys within the indexes
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        SortQueue<Key> queue = new SortQueue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    /**
     * Structures the tree according to a binary search tree
     * Works recursively through comparisons, changing current
     * node to the one to the right or the left until the right
     * key to enqueue is found.
     * @param x is current node
     * @param queue is queue in which we save the keys in
     * @param lo is the lowest index
     * @param hi is the highest index
     */
    private void keys(Node x, SortQueue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    /**
     * Calls other min node function
     * @return the node to the most left
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    /**
     * Gets the mode to the most left
     * @param x is current node
     * @return the node to the most left
     */
    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    /**
     * Calls other max node function
     * @return the node to the most right
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    /**
     * Gets the node to the most right
     * @param x is current node
     * @return node to the most right
     */
    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    /**
     *
     * @return true if tree is rightfully created and ordered
     */
    private boolean isBST() {
        return isBST(root, null, null);
    }

    /**
     * Iterates through the tree and sees that all the
     * keys to the left is smaller and all the keys to
     * the right is bigger.
     * Method works recursively and checks the whole tree
     * (both subtrees)
     * @param x   is current node
     * @param min is node to the most left
     * @param max is node to the most right
     * @return true if the tree is sorted as it should
     */
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    /**
     *
     * @return if the size of the tree stays consistent
     */
    private boolean isSizeConsistent() { return isSizeConsistent(root); }

    /**
     * Checks if the size of the three is all nodes
     * in both subtree + the root.
     * Method works recursively through the two subtrees
     * @param x is current node
     * @return true if the size stays consistent
     */
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    /**
     *
     * @return true if the right rank is returned
     */
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }

    /**
     * Getter of key at specific rank
     * @param rank is wanted rank of key
     * @return the key with that rank
     */
    public Key select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(root, rank);
    }

    /**
     * Moves recursively through the tree until the
     * node with the right size/rank is found
     * @param x    is current node
     * @param rank is rank of wanted node
     * @return the key of the right rank/size
     */
    private Key select(Node x, int rank) {
        if (x == null) return null;
        int leftSize = size(x.left);
        if      (leftSize > rank) return select(x.left,  rank);
        else if (leftSize < rank) return select(x.right, rank - leftSize - 1);
        else                      return x.key;
    }

    /**
     * Calls other rank method and sends in the root
     * @param key is wanted key
     * @return the rank of wanted key
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    /**
     * Moves recursively through the tree until the node
     * with wanted key is found.
     * Method works recursively through the tree until the node
     * is found.
     * @param key for wanted rank
     * @param x is current node
     * @return rank of the node with the given key
     */
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }

    /**
     * Tests for if the tree is built correctly
     * @return true if it is
     */
    private boolean check() {
        if (!isBST())            System.out.println("Not in symmetric order");
        if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
        if (!isRankConsistent()) System.out.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }
}
