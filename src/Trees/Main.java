package Trees;

public class Main {

    public static void main(String[] args){
        TreeADT tree = new TreeADT(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        int total = 0;
        System.out.println(tree.count(tree.root, 0 ,total));
    }

}
