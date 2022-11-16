import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada<T> implements Iterable<T>{
	
	Nodo cabeza;
	Comparator<T> orden;
	private int size;
	
	public ListaVinculada(Comparator <T> orden) {
		this.cabeza=null;
		this.size=0;
		this.orden=orden;
	}

	public void InsertarOrdenado(Object obj) {
		Nodo nuevo= new Nodo(obj);
		if(estaVacia()) {
			cabeza = nuevo;
		}else {
			Nodo anterior=null;
			while(this.cabeza!=null && orden.compare(this.cabeza.obtenerValor(), nuevo.obtenerValor())<0) {
				anterior = cabeza;
				this.cabeza=this.cabeza.obtenerSiguiente();		
			}if(this.cabeza==null) {
				anterior.enlazarSiguiente(nuevo);
			}else {
				nuevo.enlazarSiguiente(this.cabeza);
		}
		}
		size++; 
	}
	
	public void ordenar() {
		Nodo ant=null;
		while(this.cabeza!=null && orden.compare(this.cabeza.obtenerValor(), ant.obtenerValor())<0) {
			ant=this.cabeza;
			this.cabeza=this.cabeza.obtenerSiguiente();
		}
		
	}
	
//	public Object obtener(Integer index) {
//		int contador =0;
//		Nodo temp= cabeza;
//		while(contador<index) {
//			temp= temp.obtenerSiguiente();
//			contador ++;
//		}
//		return temp.obtenerValor();
//	}
	
	
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
			temporal.enlazarSiguiente(
					temporal.obtenerSiguiente().obtenerSiguiente());	
		}
		size--;
	}
	
	public Integer obtenerPosicion(T valor) {
		Nodo aux=cabeza;
		int contador=0;
		while(aux!=null && aux.obtenerValor()!=valor) {
			aux=aux.obtenerSiguiente();
			contador++;
		}
		if(aux==null) {
			return null;
		}else {
			return contador;
		}
	}
	
	public void eliminarOcurrencias(T valor) {
		Nodo aux= this.cabeza;
			while(aux!=null) {
				if(aux.obtenerValor()==valor) {
					aux=aux.obtenerSiguiente();	
					size--;
				}
				aux=aux.obtenerSiguiente();
			}	
	}
	
	public boolean estaVacia() {
		return (this.cabeza==null);
	}
	
	public int getSize() {
		return size;
	}
	
	public void setOrden(Comparator<T> orden) {
		this.orden = orden;
		ordenar();
	}

	public Iterator<T> iterator(){
		return new IteradorNodo(this.cabeza);
	}
	
//	public void mostrarLista() {
//		Iterator<T> it = this.iterator();
//		while(it.hasNext()) {
//			T index= it.next();
//		}
//		
//	}
	
	private class IteradorNodo implements Iterator<T>{
		private Nodo nodo;
		
		public IteradorNodo(Nodo n) {
			this.nodo=n;
		}
		@Override
		public boolean hasNext() {
			return nodo.obtenerSiguiente()!=null;
		}
		
		@Override
		public T next() {
			T valor=(T) nodo.obtenerValor();
			nodo = nodo.obtenerSiguiente();
			return valor; 
		}
	}

	
	
	
	
}
