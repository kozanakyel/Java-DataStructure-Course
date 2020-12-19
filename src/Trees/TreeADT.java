package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//binary tree for BFS(BreathFirstSearch)
public class TreeADT {
    Node root;
    TreeADT(int data){
        root = new Node(data);
    }
    void insert(int data){
        insert(this.root, data);
    }

    void insert(Node p, int data){
        Queue<Node> q = new LinkedList<>();
        q.add(p);

        while(!q.isEmpty()){
            Node tmp = q.peek();
            q.remove();
            boolean a = false;
            for (Node c : tmp.children){
                if (c == null){
                    tmp.children.add(new Node(data));
                    a = true;
                    break;
                }else q.add(c);
            }
            if (a) break;

            if (tmp.left == null){
                tmp.left = new Node(data);
                break;
            } else q.add(tmp.left);
            if (tmp.right == null){
                tmp.right = new Node(data);
                break;
            }else q.add(tmp.right);

        }
    }

    int count(Node p, int k, int total){
        int result = 0;
        if (p == null)
            return 0;
        if (k == 1 && (p.left != null && p.right != null))
            result += 1;
        count(p.left, 1, result);
        count(p.right, 0, result);
        return result;
    }
}

class Node{
    int data;
    Node left, right, parent;
    ArrayList<Node> children;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
        parent = null;
        children = new ArrayList<>();
    }
}