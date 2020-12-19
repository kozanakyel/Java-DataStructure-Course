package Stack;

public class Josephus {
    public static <E> E Josephus(CircularlyLinkedQueue<E> queue, int k){
        if (queue.isEmpty()) return null;
        while (queue.size() > 1){
            for (int i = 0; i < k-1; i++)
                queue.rotate();
            E e = queue.dequeue();
            System.out.println("       " + e + " is out ");
        }
        return queue.dequeue();
    }

    public static <E> CircularlyLinkedQueue<E> buildQueue(E[] a){
        CircularQueue<E> queue = new CircularlyLinkedQueue<E>();
        for (E e : a) queue.enqueue(e);
        return (CircularlyLinkedQueue<E>)queue;
    }
}
