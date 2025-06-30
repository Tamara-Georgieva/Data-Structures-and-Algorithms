import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

	K key;
	E value;

	public MapEntry(K key, E val) {
		this.key = key;
		this.value = val;
	}

	public int compareTo(K that) {
		@SuppressWarnings("unchecked")
		MapEntry<K, E> other = (MapEntry<K, E>) that;
		return this.key.compareTo(other.key);
	}

	public String toString() {
		return "<" + key + "," + value + ">";
	}
}

class SLLNode<E> {
	protected E element;
	protected SLLNode<E> succ;

	public SLLNode(E elem, SLLNode<E> succ) {
		this.element = elem;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}

class CBHT<K extends Comparable<K>, E> {

	private SLLNode<MapEntry<K, E>>[] buckets;

	@SuppressWarnings("unchecked")
	public CBHT(int m) {
		buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % buckets.length;
	}

	public SLLNode<MapEntry<K, E>> search(K targetKey) {
		int b = hash(targetKey);
		for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
			if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
				return curr;
		}
		return null;
	}

	public void insert(K key, E val) { 
		MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
		int b = hash(key);
		for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
			if (key.equals(((MapEntry<K, E>) curr.element).key)) {
				curr.element = newEntry;
				return;
			}
		}
		buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
	}

	public void delete(K key) {
		int b = hash(key);
		for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
			if (key.equals(((MapEntry<K, E>) curr.element).key)) {
				if (pred == null)
					buckets[b] = curr.succ;
				else
					pred.succ = curr.succ;
				return;
			}
		}
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < buckets.length; i++) {
			temp += i + ":";
			for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
				temp += curr.element.toString() + " ";
			}
			temp += "\n";
		}
		return temp;
	}

}

class ImeLek implements Comparable<ImeLek> {
	String ime;

	public ImeLek(String ime) {
		super();
		this.ime = ime;
	}

	@Override
	public int compareTo(ImeLek il) {
		return ime.compareTo(il.ime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImeLek other = (ImeLek) obj;
		return Objects.equals(ime, other.ime);
	}

	public int hashCode() {
		int result = 0;
		result = (29 * (29 * (29 * 0 + ime.charAt(0)) + ime.charAt(1)) + ime.charAt(2)) % 102780;
		return result;

	}


}


class Lek {
	String ime;
	int pozneg;
	int cena;
	int kolichina;

	public Lek(String ime, int pozneg, int cena, int kolichina) {
		super();
		this.ime = ime;
		this.pozneg = pozneg;
		this.cena = cena;
		this.kolichina = kolichina;
	}	

	@Override
	public String toString() {
		String s=ime+"\n";
		if(pozneg==1)
			s+="POZ\n";
		else
			s+="NEG\n";
		//s+=(pozneg==1)?"POZ":"NEG";
		s+=cena+"\n";
		s+=kolichina+"\n";		
		return s;
	}

}

public class HashAptekaImeLekLekCBHT {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int i, n, pozneg, cena, kolichina;
	String ime, s;
	String[] pom;
	ImeLek il = null;
	Lek l = null;
	SLLNode<MapEntry<ImeLek, Lek>> tmp = null;
	s=br.readLine();
	n=Integer.parseInt(s);
	CBHT<ImeLek, Lek> tabela = new CBHT<ImeLek, Lek>(2 * n + 1);

	for(i=0;i<n;i++)
	{
		s=br.readLine();
		pom=s.split(" ");
		ime=pom[0].toUpperCase();
		pozneg=Integer.parseInt(pom[1]);
		cena=Integer.parseInt(pom[2]);
		kolichina=Integer.parseInt(pom[3]);
		il=new ImeLek(ime);
		l=new Lek(ime, pozneg, cena, kolichina);
		tabela.insert(il, l);
		
		}
	while(true)
	{
		ime=br.readLine().toUpperCase();
		if(ime.equals("KRAJ"))
		{
			break;
		}
		s=br.readLine();
		kolichina=Integer.parseInt(s);
		il=new ImeLek(ime);
		tmp=tabela.search(il);
		if(tmp==null)
			System.out.println("Nema takov lek");
		else
		{
			Lek najden=tmp.element.value;
			System.out.print(najden);
		/*	System.out.print(najden.ime);
			if(najden.pozneg==1)
				System.out.println("Poz");
			else System.out.println("NEG");
			System.out.println(najden.cena);
			System.out.println(najden.kolichina); */
			if(kolichina<=najden.kolichina)
			{
				najden.kolichina-=kolichina;
				tabela.insert(il, najden);
				System.out.println("Napravena naracka");
			}
			else
			{
				System.out.println("Nema dovolno lekovi");
			}
			
		}
		
	}
}
}
	
