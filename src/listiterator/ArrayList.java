package listiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    public ArrayList(){this(CAPACITY);}
    public ArrayList(int capacity){
        data = (E[])new Object[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        checkIndex(index, size);
        return data[index];
    }

    public E set(int index, E element) throws IndexOutOfBoundsException{
        checkIndex(index, size);
        E temp = data[index];
        data[index] = element;
        return temp;
    }

    public void add(int index, E element) throws IndexOutOfBoundsException,
                                    IllegalStateException{
        checkIndex(index, size+1);
        if(size == data.length)
            reSize(2 * data.length);
        for (int k = size-1; k >= index; k--)
            data[k+1] = data[k];
        data[index] = element;
        size++;
    }

    public E remove(int index) throws IndexOutOfBoundsException{
        checkIndex(index, size);
        E temp = data[index];
        for (int k = index; k < size-1; k++)
            data[k] = data[k+1];
        data[size-1] = null;
        size--;
        return temp;
    }

    protected void reSize(int capacity){
        E[] temp = (E[])new Object[capacity];
        for (int k=0; k < size; k++)
            temp[k] = data[k];
        data = temp;
    }

    protected void checkIndex(int index, int size){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Illegal index: " + index);
    }

    private class ArrayIterator implements Iterator<E>{
        private int j = 0;
        private boolean removable = false;

        public boolean hasNext(){ return j < size;}
        public E next() throws NoSuchElementException{
            if (j == size) throw new NoSuchElementException("No next element");
            removable = true;
            return data[j++];
        }

        public void remove() throws IllegalStateException{
            if (!removable) throw new IllegalStateException("nothing to remove.");
            ArrayList.this.remove(j-1);
            j--;
            removable = false;
        }
    }

    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
}
