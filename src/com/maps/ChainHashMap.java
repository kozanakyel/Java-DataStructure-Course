package com.maps;

import com.priorityqueue.Entry;

import java.util.ArrayList;

public class ChainHashMap<K,V> extends AbstractHashMap {
    private UnsortedTableMap[] table; // initialized within createTable
    public ChainHashMap() { super(); }
    public ChainHashMap(int cap) { super(cap); }
    public ChainHashMap(int cap, int p) { super(cap, p); }

    protected void createTable() {
        table = new UnsortedTableMap[capacity];
    }

    protected V bucketGet(int h, Object k) {
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        return bucket.get((K)k);
    }

    protected V bucketPut(int h, Object k, Object v) {
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null)
            bucket = table[h] = new UnsortedTableMap<>();
        int oldSize = bucket.size();
        V answer = bucket.put((K)k,(V)v);
        n += (bucket.size() - oldSize);        // size may have increased
        return answer;
    }

    protected V bucketRemove(int h, Object k) {
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        int oldSize = bucket.size();
        V answer = bucket.remove((K)k);
        n -= (oldSize - bucket.size());
        return answer;
    }

    public Iterable<Entry<K,V>> entrySet( ) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>( );
        for (int h=0; h < capacity; h++)
            if (table[h] != null)
                for (Object entry : table[h].entrySet()){
                    buffer.add((Entry<K,V>)entry);
                }
        return buffer;
    }

}
