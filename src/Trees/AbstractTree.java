package Trees;

import Stack.ArrayQueue;
import Stack.Queue;
import listiterator.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {

    public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
    public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
    public boolean isRoot(Position<E> p) { return p == root(); }
    public boolean isEmpty() { return size() == 0; }
    public int depth(Position<E> p){
        if (isRoot(p))
            return 0;
        return 1 + depth(parent(p));
    }

    private int heightBad(){
        int h = 0;
        for (Position<E> p : positions())  //O(n^2)
            if (isExternal(p))
                h = Math.max(h, depth(p));
        return h;
    }

    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p))  // base case if p is external
            h = Math.max(h, 1 + height(c));
        return h;
    }

    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preOrderSubtree(c, snapshot);
    }

    public Iterable<Position<E>> preOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preOrderSubtree(root(), snapshot);
        return snapshot;
    }

    private void postOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postOrderSubtree(c, snapshot);
        snapshot.add(p);
    }

    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postOrderSubtree(root(), snapshot);
        return snapshot;
    }

    public Iterable<Position<E>> breadthFirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()){
            Queue<Position<E>> fringe = new ArrayQueue<Position<E>>();
            fringe.enqueue(root());
            while (!fringe.isEmpty()){
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> c: children(p))
                    fringe.enqueue(c);
            }
        }
        return snapshot;
    }

}

