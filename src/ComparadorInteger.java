import java.util.Comparator;

public class ComparadorInteger<T> implements Comparator<T> {
	
		public int compare(T o1, T o2) {
			Integer in1= (Integer)o1;
			Integer in2= (Integer)o2;
			
			return in1-in2;

		}




}
