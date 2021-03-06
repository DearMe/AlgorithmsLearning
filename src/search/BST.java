package search;

/**
 * Created by ruanqx on 2015/8/27.
 */
public class BST<Key extends Comparable<Key>, Value>{
    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }
    public int size(Node x){
        if(x == null)
            return 0;
        else
            return x.N;
    }

    public Value get(Key key){
        return get(root, key);
    }

    public Value get(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left, key);
        else if(cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null) new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, val);
        else if(cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left == null) return x;
        else return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right == null) return x;
        else return max(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t == null) return x;
        else return t;
    }

    public Key ceiling(Key key){
        Node x = ceiling(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if(t == null) return x;
        else return t;
    }

    public Key select(int k){
        return select(root, k).key;
    }
    private Node select(Node x, int k){
        if(x == null) return null;
        int t = size(x.left);
        if(t > k) return select(x.left, k);
        else if(t < k) return select(x. right, k-t-1);
        else return x;
    }

    public int rank(Key key){
        return rank(root, key);
    }
    private int rank(Node x, Key key) {
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(x.left, key);
        else if(cmp > 0) return size(x.left) + rank(x.right, key) + 1;
        else return size(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, key);
        else if(cmp > 0) x.right = delete(x.right, key);
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(x.right);
            x.left = t.left;
            x.right = t.right;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}
