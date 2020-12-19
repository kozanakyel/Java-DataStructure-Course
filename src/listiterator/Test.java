package listiterator;


import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args){
        ArrayList<Double> arr = new ArrayList<>();
        for(int i = -5; i < 10; i++)
            arr.add((double)i);
        arr.removeIf(aDouble -> aDouble < 0.0);
        System.out.println(arr);

        LinkedPositionalList<String> newest = new LinkedPositionalList<>();
        newest.addFirst("First");
        newest.addFirst("before");
        newest.addLast("bakak");
        newest.addFirst("galata");
        System.out.println(newest.addBefore(newest.first(), "kalem"));
        Iterator<String> iter = newest.iterator();
        while (iter.hasNext()){
            String element = "";
            if (iter.next().equals("galata"))
                element = iter.next();
            System.out.println(element);
        }
    }
}
