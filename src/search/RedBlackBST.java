package search;

import javafx.scene.shape.VLineTo;

/**
 * Created by ruanqx on 2015/9/1.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> extends ST{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        Node(Key key, Value val, int N, boolean color){
            this.key = key;
            this.value = val;
            this.N = N;
            this.color = color;
        }

        public int size(){
            return size(root);
        }
        private int size(Node x){
            if(x == null) return 0;
            return x.N;
        }

        private boolean isRed(Node x) {
            return x != null && color;
        }

        private Node balance(Node h){
            if(isRed(h.right)) h = rotateLeft(h);
            if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
            if(isRed(h.left) && isRed(h.right)) flipColors(h);
            h.N = size(h.left) + size(h.right) + 1;
            return h;
        }

        private Node rotateLeft(Node h){
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.color = RED;
            x.N = h.N;
            h.N = 1 + size(h.left) + size(h.right);
            return x;
        }

        private Node rotateRight(Node h){
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.N = h.N;
            h.N = 1 + size(h.left) + size(h.right);
            return x;
        }

        private void flipColors(Node h){
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }

        public Node put(Node h, Key key, Value val){
            if(h == null)
                return new Node(key, val, 1, RED);
            int cmp = key.compareTo(h.key);
            if(cmp < 0) return h.left = put(h.left, key, val);
            else if(cmp > 0) h.right = put(h.right, key, val);
            else h.value = val;

            if(!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
            if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
            if(isRed(h.left) && isRed(h.right)) flipColors(h);

            h.N = size(h.left) + size(h.right) + 1;
            return h;
        }

        public void deleteMin(){
            if(!isRed(root.left) && !isRed(root.right))
                root.color = RED;
            root = deleteMin(root);
            if(!isEmpty()) root.color = BLACK;
        }

        private Node deleteMin(Node h) {
            if(h.left == null)
                return null;
            if(!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = deleteMin(h.left);
            return balance(h);
        }

        private Node moveRedLeft(Node h) {
            flipColors(h);
            if(isRed(h.right.left)){
                h.right = rotateRight(h.right);
                h = rotateLeft(h);
            }
            return h;
        }
    }
}
