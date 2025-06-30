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

