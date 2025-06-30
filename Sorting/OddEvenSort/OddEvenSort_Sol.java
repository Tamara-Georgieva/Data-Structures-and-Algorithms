import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {
	
	static void oddEvenSort(int a[], int n)
	{
		int i, j;
        for(i=0;i<n-1;i++)
        for(j=i+1;j<n;j++)
        {
            if((a[i]%2==1)&&(a[j]%2==1)&&(a[i]>a[j]))
            {
                 int tmp = a[i];
                 a[i] = a[j];
                 a[j] = tmp;
            }
            else if((a[i]%2==0)&&(a[j]%2==0)&&(a[i]<a[j]))
            {
                 int tmp = a[i];
                 a[i] = a[j];
                 a[j] = tmp;
            }
            else if((a[i]%2==0)&&(a[j]%2==1))
            {
                 int tmp = a[i];
                 a[i] = a[j];
                 a[j] = tmp;
            }
        }
	}

	public static void main(String[] args) throws IOException{
		int i;
		BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in)); 
		String s = stdin.readLine();
		int n = Integer.parseInt(s);
		
		s = stdin.readLine();
		String [] pom = s.split(" ");
		int [] a = new int[n];
		for(i=0;i<n;i++)
			a[i]=Integer.parseInt(pom[i]);
		oddEvenSort(a,n);
		for(i=0;i<n-1;i++)
			System.out.print(a[i]+" ");
		System.out.print(a[i]);
	}
}
