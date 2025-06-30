import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.ArrayList;


class BNode<E> {
    
    public E info;
    public BNode<E> left;
    public BNode<E> right;
    
    static int LEFT = 1;
    static int RIGHT = 2;
    
    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }
    
    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
}

class BTree<E> {
    
    public BNode<E> root;
    
    public BTree() {
        root = null;
    }
    
    public BTree(E info) {
        root = new BNode<E>(info);
    }
    
    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }
    
    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        
        BNode<E> tmp = new BNode<E>(elem);
        
        if (where == BNode.LEFT) {
            if (node.left != null) 
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) 
                return null;
            node.right = tmp;
        }
        
        return tmp;
    }
    
    public void inorder() {
        System.out.print("INORDER: ");
        inorderR(root);
        System.out.println();
    }
    
    public void inorderR(BNode<E> n) {
        if (n != null) {
            inorderR(n.left);
            System.out.print(n.info.toString()+" ");
            inorderR(n.right);
        }
    }

    public void preorder() {
        System.out.print("PREORDER: ");
        preorderR(root);
        System.out.println();
    }
    
    public void preorderR(BNode<E> n) {
        if (n != null) {
            System.out.print(n.info.toString()+" ");
            preorderR(n.left);
            preorderR(n.right);
        }
    }
    public void preorder(ArrayList<Integer> lista) {
        preorderR(root,lista);
    }
    
    public void preorderR(BNode<E> n, ArrayList<Integer> lista) {
        if (n != null) {
            lista.add(Integer.parseInt(n.info.toString()));
            preorderR(n.left,lista);
            preorderR(n.right,lista);
        }
    }
    
    public void postorder() {
        System.out.print("POSTORDER: ");
        postorderR(root);
        System.out.println();
    }
    
    public void postorderR(BNode<E> n) {
        if (n != null) {
            postorderR(n.left);
            postorderR(n.right);
            System.out.print(n.info.toString()+" ");
        }
    }
    
    public void inorderNonRecursive() {
        Stack<BNode<E>> s = new Stack<BNode<E>>();
        BNode<E> p = root;
        System.out.print("INORDER (nonrecursive): ");
        
        while (true) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            
            if (s.isEmpty())
                break;

            p = s.peek();
            System.out.print(p.info.toString()+" ");
            s.pop();
            p = p.right;
            
        }
        System.out.println();
        
    }    
     
}

public class ConsecutiveNumbers {
    
    public static void main(String[] args) throws Exception {
        int i,j,k;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        BNode<Integer> nodes[] = new BNode[N];        
        BTree<Integer> tree = new BTree<Integer>();

        for (i=0;i<N;i++)
            nodes[i] = null;

        for (i = 0; i < N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int index = Integer.parseInt(st.nextToken());
            nodes[index] = new BNode<Integer>(Integer.parseInt(st.nextToken()));
            String action = st.nextToken();
            if (action.equals("LEFT")) {
                BNode<Integer> child = tree.addChild(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index].info);
                nodes[index] = child;
            } else if (action.equals("RIGHT")) {
                BNode<Integer> child = tree.addChild(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index].info);
                nodes[index] = child;
            } else {
                // this node is the root
                tree.makeRoot(nodes[index].info);
                nodes[index] = tree.root;
            }
        }
        
        br.close();
        //tree.preorder();
        ArrayList<Integer> al=new ArrayList<Integer>();
        tree.preorder(al);
        //System.out.print(al);
        int broj=al.get(0);
        for(i=1;i<al.size();i++)
        {
            if((broj+2)!=(al.get(i)))
            {
                System.out.print(false);
                break;
            }
            broj+=2;
        }
        if(i==al.size())
         System.out.print(true);
    
        
    }
    
}
