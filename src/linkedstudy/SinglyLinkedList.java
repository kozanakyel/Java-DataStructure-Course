package linkedstudy;

public class SinglyLinkedList<E> implements Cloneable {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){}

    public int size(){ return size;}
    public boolean isEmpty(){ return size == 0;}
    public E first(){
        if(size==0) return null;
        return head.getElement();
    }
    public E last(){
        if (size==0) return null;
        return tail.getElement();
    }
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(size==0) tail = head;
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size==0)
            tail = null;
        return answer;
    }

    public boolean equals(Object o){
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SinglyLinkedList<E> other = (SinglyLinkedList<E>)o;
        if (size != other.size) return false;
        Node<E> walkA = head;
        Node<E> walkB = other.head;
        while (walkA != null){
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    public boolean lastToSecond(){
        Node<E> current;
        if(isEmpty())
            return false;
        current = head;
        while (current.next.next.next != null){
            current = current.next;
        }
        System.out.println(current.getElement());
        return true;
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
        SinglyLinkedList<E> other = (SinglyLinkedList<E>)super.clone();
        if (size>0){
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;
            while (walk != null){
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }
}
