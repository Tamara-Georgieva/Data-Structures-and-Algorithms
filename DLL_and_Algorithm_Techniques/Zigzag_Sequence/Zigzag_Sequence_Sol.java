import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {
    
    static int najdiNajdolgaCikCak(int a[]) {
		int brojac = 1;
		int najdolg = 0;
		
		for (int i = 1; i < a.length; i++) {
			if (a[i] == 0)
				brojac = 0;

			if (a[i] > 0) {
				if (a[i - 1] < 0)
					brojac++;
				else
					brojac = 1;
			}
			if (a[i] < 0) {
				if (a[i - 1] > 0)
					brojac++;
				else
					brojac = 1;
			}
			if (brojac > najdolg)
				najdolg = brojac;
		}
		return najdolg;
    }
    
    public static void main(String[] args) throws Exception {
        int i,j,k;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());
        
        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);
        
        br.close();
       	
    }
    
}
