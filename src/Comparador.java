import java.util.Comparator;

public abstract class Comparador<T> implements Comparator<T>{
	public abstract int compare(T o1 , T o2 );
}

