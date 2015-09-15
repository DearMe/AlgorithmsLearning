package search;

/**
 * Created by ruanqx on 2015/8/19.
 */
public class ST<Key, Value>{
    ST(){}
    void put(Key key, Value value){}
    Value get(Key key){return null;}
    void delete(Key key){}
    boolean contains(Key key){return false;}
    boolean isEmpty(){return true;}
    int size(){return 0;}
    Iterable<Key> keys(){return null;}
}
