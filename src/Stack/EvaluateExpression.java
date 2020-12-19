package Stack;

public class EvaluateExpression {
    public static void main(String[] args){

    }

    public static String insertBlanks(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                s.charAt(i) == '+' || s.charAt(i) == '-' ||
                s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }
        return result;
    }

    public static void processAndOperator(
            Stack<Integer> opearndStack, Stack<Character> operatorStack
    ){
        char op = operatorStack.pop();
        int op1 = opearndStack.pop();
        int op2 = opearndStack.pop();
        if (op == '+')
            opearndStack.push(op1 + op2);
        else if (op == '-')
            opearndStack.push(op1 - op2);
        else if (op == '*')
            opearndStack.push(op1 * op2);
        else if (op == '/')
            opearndStack.push(op1/op2);
    }

    public static int evaluateExpression(String expression){
        ArrayStack<Integer> operandStack = new ArrayStack<Integer>();

        ArrayStack<Character> operatorStack = new ArrayStack<Character>();

        expression = insertBlanks(expression);
        String[] tokens = expression.split(" ");

        for (String token: tokens){
            if (token.length() == 0)
                continue;

        }
        return 0;
    }
}
