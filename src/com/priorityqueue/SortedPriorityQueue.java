package com.priorityqueue;

import listiterator.LinkedPositionalList;
import listiterator.Position;

import java.util.Comparator;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{
    private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    public SortedPriorityQueue(){super();}
    public SortedPriorityQueue(Comparator<K> comp){super(comp);}

    public Entry<K,V> insert(Object key, Object value) throws IllegalArgumentException{
        checkKey((K)key);
        Entry<K,V> newest = new PQEntry<K,V>((K)key, (V)value);
        Position<Entry<K,V>> walk = list.first();

        while (walk != null && compare(newest, walk.getElement())<0)
            walk = list.before(walk);
        if (walk == null)
            list.addFirst(newest);
        else
            list.addAfter(walk,newest);
        return newest;
    }

    public Entry<K,V> min( ) {
        if (list.isEmpty( )) return null;
        return list.first( ).getElement( );
    }

    public Entry<K,V> removeMin( ) {
        if (list.isEmpty( )) return null;
        return list.remove(list.first( ));
    }

    public int size( ) { return list.size( ); }

    public static void main(String[] args){
        SortedPriorityQueue<Integer, String> list = new SortedPriorityQueue<>();
        list.insert(21, "egasntrik");
        list.insert(34, "şükela");
        list.insert(3, "galatasaray");
        System.out.println(list.removeMin().getValue());
    }

}
