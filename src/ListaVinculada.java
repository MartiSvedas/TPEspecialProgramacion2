import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada implements Iterable<Object>{
	
	Nodo cabeza;
	Comparator<Object> orden;
	private int size, valor;
	
	public ListaVinculada(Comparator <Object> orden) {
		this.cabeza=null;
//		this.size=0;
		this.orden=orden;
		this.valor=-1;
	}
	
	public void setValor(int valor) {
		if(valor!=0) {
			this.valor = valor;	
		}
	}

	public void addNodo(Object obj) {
		Nodo nuevo= new Nodo(obj);
		if(estaVacia()) {
			cabeza = nuevo;
		}else {
			Nodo anterior=null;
			Nodo temp = this.cabeza;
			while(temp!=null && orden.compare(temp, nuevo)<this.valor) {
				anterior = cabeza;
				temp=temp.obtenerSiguiente();
			}if(temp==null) {
				anterior.enlazarSiguiente(nuevo);
			}else {
				nuevo.enlazarSiguiente(temp);
		}
		}
//		size++; 
	}
	
	public Object obtener(Integer index) {
		int contador =0;
		Nodo temp= cabeza;
		while(contador<index) {
			temp= temp.obtenerSiguiente();
			contador ++;
		}
		return temp.obtenerValor();
	}
	
	public void eliminarSegunPosicion(Integer index) {
		int contador = 0;
		if(index==0) {
			cabeza=cabeza.obtenerSiguiente();
		}else {
			Nodo temporal = cabeza;
			while(contador<index-1) {
				temporal = temporal.obtenerSiguiente();
				contador ++;
			}	
			temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());	
		}
		
	}
	
	public boolean estaVacia() {
		return (this.cabeza==null);
	}
	
	public int getSize() {
		return size;
	}
	
	
	public void setOrden(Comparator<Object> orden) {
		this.orden = orden;
	}

	public Iterator<Object> iterator(){
		return new IteradorNodo();
	}
	
	private class IteradorNodo implements Iterator<Object>{
		private Nodo nodo;
		
		public IteradorNodo() {
			this.nodo= null;
		}
		@Override
		public boolean hasNext() {
			return nodo.obtenerSiguiente()!=null;
		}
		
		@Override
		public Nodo next() {
			return nodo.obtenerSiguiente();
		}
	}

	
	
	
	
}
