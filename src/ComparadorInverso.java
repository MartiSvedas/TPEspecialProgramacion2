import java.util.Comparator;

public class ComparadorInverso implements Comparator<Object> {
	private Comparator<Object> comp;
	
	public ComparadorInverso(Comparator<Object> comp) {
		this.comp=comp;
	}

	@Override
	public int compare(Object o1, Object o2) {
		return comp.compare(o1, o2) * -1;
	}
}
