import java.util.Comparator;

public class ComparadorString<T> implements Comparator<T>{
	public int compare(T o1, T o2) {
		String st1=(String)o1;
		String st2=(String) o2;
		
		return st1.compareTo(st2);
		
	}

}
