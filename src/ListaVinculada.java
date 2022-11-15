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
			Nodo temp = this.cabeza;
			while(temp!=null && orden.compare(temp, nuevo)<0) {
				anterior = cabeza;
				temp=temp.obtenerSiguiente();		
			}if(temp==null) {
				anterior.enlazarSiguiente(nuevo);
			}else {
				nuevo.enlazarSiguiente(temp);
		}
		}
		size++; 
	}
	
	public void ordenar() {
		Nodo aux= this.cabeza;
		Nodo ant=null;
		while(aux!=null && orden.compare(aux, ant)<0) {
			ant=aux;
			aux=aux.obtenerSiguiente();
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
