import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

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

    public BNode() {
        this.info = null;
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

    public void makeRootNode(BNode<E> node) {
        root = node;
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

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

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
    
    public void PreorderNonRecursive() {
		ArrayStack<BNode<E>> stek = new ArrayStack<BNode<E>>(1000);
		String res = "";
		stek.push(root);
		while (!stek.isEmpty()) {
			BNode<E> jazol = stek.pop();
			res = res + jazol.info + " ";
			if (jazol.right != null)
				stek.push(jazol.right);
			if (jazol.left != null)
				stek.push(jazol.left);
		}
		System.out.print(res);
	}

}

interface Stack<E> {


    public boolean isEmpty ();

    public E peek ();

    public void clear ();

    public void push (E x);

    public E pop ();
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        return (depth == 0);
    }


    public E peek () {
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        elems[depth++] = x;
    }


    public E pop () {
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class PreorderNonRecursive {

    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        BNode<String> nodes[] = new BNode[N];
        BTree<String> tree = new BTree<String>();

        for (i=0;i<N;i++)
            nodes[i] = new BNode<String>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                tree.makeRootNode(nodes[index]);
            }
        }

        br.close();

        tree.PreorderNonRecursive();

    }
}
