За дадена низа од случајни броеви кои се внесуваат од стандарден влез, да се направи преместување на сите нули на почеток на низата. На стандарден излез да се испечати трансформираната низа.
//For a given array of random numbers given from standard input, perform a shift of all zeros at the beginning of the sequence. Print the transformed array to standard output.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PushZero
{
	static void pushZerosToBeginning(int arr[], int n)
	{
	    int count=0;
	    
		int k=n-1;
		for(int i=n-1; i>=0; i--)
		{
			if(arr[i]!=0)
			{
				arr[k]=arr[i];
				k--;
				count++;
			}
		}
		
		for(int i=0;i<(n-count);i++)
		{
			arr[i]=0;
		}
	
	}

	public static void main (String[] args) throws IOException
	{
		  BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
	      String s;
			int i, n, broj;
			String[] pom;
			s = br.readLine();
			n = Integer.parseInt(s);
			int[] array=new int[n];
			s = br.readLine();
			pom = s.split(" ");
			for (i = 0; i < n; i++) {
				broj = Integer.parseInt(pom[i]);
				array[i]=broj;
			}
			
			pushZerosToBeginning(array,n);
			System.out.println("Transformiranata niza e:");
			s="";
			for (i = 0; i < n; i++) {
				s+=String.valueOf(array[i])+" ";
			}
			System.out.println(s);
		
	}
}


За даден збор кој се внесува од стандарден влез, да се испечати истиот превртен. На влез во првиот ред се дава број на зборови кои ќе се внесуваат. Во наредните линии се внесуваат самите зборови.
// For a given word entered from standard input, print it reversed. On input in the first line, the number of words that will be entered is given. In the following lines, the words are entered.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        
    	String s="";
    
    	for(int i=(word.length()-1);i>=0;i--) {
    		s+=word.charAt(i);
    	
    	}
    	
    	System.out.println(s);
    	
    }

    public static void main(String[] args) throws IOException {
    	 BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
	      String s;
			int i, n, broj;
			String[] pom;
			s = br.readLine();
			n = Integer.parseInt(s);
			String[] array=new String[n];
			
			
			for (i = 0; i < n; i++) {
				s = br.readLine();
				array[i]=s;
			}
			
			for (i = 0; i < n; i++) {
				printReversed(array[i]);
			}
			
    
    }
}
