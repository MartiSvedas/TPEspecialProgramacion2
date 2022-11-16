import java.util.Comparator;

public class ComparadorString implements Comparator<Object>{
	public int compare(Object o1, Object o2) {
		String st1=(String)o1;
		String st2=(String) o2;
		
		return st1.compareTo(st2);
		
	}

}
