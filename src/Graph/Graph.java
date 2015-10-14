package Graph;

import collections.Bag;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by ruanqx on 2015/9/23.
 */
public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(DataInputStream in) throws IOException {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(ArrayList ins){
        this((int)ins.get(0));
        int E = (int)ins.get(1);
        for(int i=2; i<ins.size(); i++){
            int v = (int)ins.get(i);
            int w = (int)ins.get(++i);
            addEdge(v, w);
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
