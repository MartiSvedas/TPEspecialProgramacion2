import java.util.Comparator;

public class ComparadorInteger implements Comparator<Object> {
	
		public int compare(Object o1, Object o2) {
			Integer in1= (Integer)o1;
			Integer in2= (Integer)o2;
			
			return in1-in2;

		}




}
