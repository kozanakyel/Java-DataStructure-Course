package linkedstudy;

public class DoublyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E element, Node<E> prev, Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public Node<E> getNext(){return next;}
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public E middle(){
        if(size == 0) return null;
        Node<E> middleHead = header.getNext();
        Node<E> middleEnd = trailer.getPrev();
        while(middleHead != middleEnd && middleHead.getNext() != middleEnd){
            middleHead = middleHead.getNext();
            middleEnd = middleEnd.getPrev();
        }
        return middleHead.getElement();
    }

    public E removeFirst(){
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast(){
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }
}
