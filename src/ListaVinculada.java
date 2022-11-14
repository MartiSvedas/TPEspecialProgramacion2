import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada implements Iterator<Object>{
	Nodo cabeza;
	Comparator<Object> orden;
	private int size;
	
	public ListaVinculada(Comparator <Object> orden) {
		this.cabeza=null;
		this.size=0;
		this.orden=orden;
	}
	
	public void addPrimero(Object obj) {
		Nodo nuevo= new Nodo(obj);
		if(cabeza==null) {
			cabeza = nuevo;
		}else {
			Nodo temp = cabeza;
			nuevo.enlazarSiguiente(temp);
			cabeza=nuevo;
		}
		size++; 
	}
	
	public boolean estaVacia() {
		return (cabeza==null);
	}
	
	public int getSize() {
		return size;
	}
	
	
	public void setOrden(Comparator<Object> orden) {
		this.orden = orden;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Nodo next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
