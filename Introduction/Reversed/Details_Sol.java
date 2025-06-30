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
