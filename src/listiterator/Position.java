package listiterator;

public interface Position<E> {
    E getElement() throws IllegalStateException;
}
