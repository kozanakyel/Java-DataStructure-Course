package com.priorityqueue;

import listiterator.PositionalList;

import java.util.Iterator;

public class Test {
    /**
     *
     * */

    public static void main(String[] args){
        SortedPriorityQueue<Integer, String> spq = new SortedPriorityQueue<>();
        spq.insert(23,"galatasaray");
        spq.insert(12,"fener");
        spq.insert(67, "trabzon");
        spq.insert(78, "besiktas");
        System.out.println(spq.toString());
        System.out.println(spq.min());

        HeapPriorityQueue<Integer, Integer> heap = new HeapPriorityQueue<>();
        heap.insert(23,12);
        heap.insert(12,45);
        heap.insert(5,34);
        heap.insert(46,16);
        System.out.println(heap);
    }

    public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E,?> P) {
        int n = S.size( );
        for (int j=0; j < n; j++) {
            E element = S.remove(S.first( ));
            P.insert(element, null);            // element is key; null value
        }
        for (int j=0; j < n; j++) {
            E element = P.removeMin().getKey();
            S.addLast(element);            // the smallest key in P is next placed in S
        }
    }

}
