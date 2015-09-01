package sort;

import javafx.scene.shape.VLineTo;

/**
 * Created by ruanqx on 2015/9/1.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

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

        private boolean isRed(Node x) {
            return x != null && color;
        }
    }
}
