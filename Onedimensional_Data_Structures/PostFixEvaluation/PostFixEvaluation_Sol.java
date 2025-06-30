import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

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

public class PostFixEvaluation {
	
    static int evaluatePostfix(char [] izraz, int n)
    {
      ArrayStack<Integer> stek = new ArrayStack<>(n);
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(izraz[i])) {
                int broj = izraz[i] - '0';
                while (i + 1 < n && Character.isDigit(izraz[i + 1])) {
                    broj = broj * 10 + (izraz[i + 1] - '0');
                    i++;
                }
                stek.push(broj);

            } else if (izraz[i] == '+' || izraz[i] == '-' || izraz[i] == '*' || izraz[i] == '/') {
                int operand2 = stek.pop();
                int operand1 = stek.pop();
                int rezultat=0;
                switch (izraz[i]) {
                    case '+':
                        rezultat = operand1 + operand2;
                        break;
                    case '-':
                        rezultat = operand1 - operand2;
                        break;
                    case '*':
                        rezultat = operand1 * operand2;
                        break;
                    case '/':
                        rezultat = operand1 / operand2;
                        break;
                    default:
                        System.out.println("Nevaliden izraz");
                }
                stek.push(rezultat);
            }
        }
        return stek.peek();
    }

	
	public static void main(String[] args) throws Exception{
          
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String expression = br.readLine();
        char exp[] = expression.toCharArray();
        
        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);
        
        br.close();

	}

}
