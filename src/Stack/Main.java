package Stack;

public class Main {
    public static void main(String[] args){
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        stack.push(24);
        stack.push(34);
        stack.push(56);
        stack.push(57);
        removedStack(stack);
        System.out.println(stack.size());
    }

    public static ArrayStack<Integer> removedStack(ArrayStack<Integer> stack){
        if (stack.isEmpty())
            return stack;
        else{
            stack.pop();
            return removedStack(stack);
        }
    }

    public static <E> void reverse(E[] a){
        Stack<E> buffer = new ArrayStack<E>(a.length);
        for (E e : a) buffer.push(e);
        for (int i = 0; i < a.length; i++)
            a[i] = buffer.pop();
    }

    public static boolean isMatched(String expression){
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new LinkedStack<Character>();
        for (char c: expression.toCharArray()){
            if (opening.indexOf(c) != -1)
                buffer.push(c);
            else if(closing.indexOf(c) != -1){
                if (buffer.isEmpty())
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false;
            }
        }
        return buffer.isEmpty();
    }
}
