package com.priorityqueue;

import listiterator.LinkedPositionalList;
import listiterator.Position;
import listiterator.PositionalList;

import java.util.Comparator;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    public UnsortedPriorityQueue(){super();}
    public UnsortedPriorityQueue(Comparator<K> comp){super(comp);}

    private Position<Entry<K,V>> findMin(){
        Position<Entry<K,V>> small = list.first();
        for (Position<Entry<K,V>> walk: list.positions())
            if (compare(walk.getElement(), small.getElement())<0)
                small = walk;
        return small;
    }

    public Entry<K,V> min() {
        if (list.isEmpty()) return null;
        return findMin().getElement();   // return list.first().getElement();
    }

    public Entry<K,V> removeMin() {
        if (list.isEmpty()) return null;
        return list.remove(findMin());    }

    public int size() { return list.size( ); }

    @Override
    public Entry<K,V> insert(Object key, Object value) throws IllegalArgumentException {
        checkKey((K)key);
        Entry<K,V> newest = new PQEntry<K,V>((K)key, (V)value);
        Position<Entry<K,V>> small = list.first();
        if (compare(newest, list.first().getElement()) < 0)
            list.addFirst(newest);

        list.addLast(newest);
        return newest;
    }
}
