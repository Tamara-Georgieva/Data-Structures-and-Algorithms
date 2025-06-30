import java.util.Scanner;

public class CountWordPairs {
    public static int countWordPairs(String [] words) {
    int i, j, brojac = 0;
		for (i = 0; i < words.length; i++) {
			char prvabukvai = Character.toLowerCase(words[i].charAt(0));
			for (j = i + 1; j < words.length; j++) {
				char prvabukvaj = Character.toLowerCase(words[j].charAt(0));
				if (prvabukvai == prvabukvaj) {
					brojac++;
				}
			}
		}
		return brojac;
	}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        String words[] = new String[N];

        for(int i=0;i<N;i++) {
            words[i] = input.next();
        }

        System.out.println(countWordPairs(words));

    }
}
