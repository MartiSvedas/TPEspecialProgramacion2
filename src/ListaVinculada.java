import java.util.Iterator;

public class ListaVinculada implements Iterator<Nodo>{
	Nodo cabeza;
	private int size;
	
	public ListaVinculada() {
		this.cabeza=null;
		this.size=0;
	}
	
	public void addPrimero(Object obj) {
		if(cabeza==null) {
			cabeza = new Nodo(obj);
		}else {
			Nodo temp = cabeza;
			Nodo nuevo = new Nodo(obj);
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
