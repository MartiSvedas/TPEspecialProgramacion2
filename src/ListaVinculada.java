import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada<T> implements Iterable<T>{
	
	Nodo<T>cabeza;
	Comparator<T> orden;
	private int size;
	
	public ListaVinculada(Comparator<T> orden) {
		this.cabeza=null;
		this.size=0;
		this.orden=orden;
	}

	public void InsertarOrdenado(T obj) {
		Nodo<T> nuevo= new Nodo<T>(obj);
		if(estaVacia()) {
			cabeza = nuevo;
		}else {
			Nodo<T> anterior=null;
			Nodo<T> temp=this.cabeza;
			while(temp!=null && orden.compare(temp.obtenerValor(), obj)<0) { //nuevo es mayor que temp avanzo
				anterior = cabeza;
				temp=temp.obtenerSiguiente();		
			}if(temp==null&&anterior!=null) {
				anterior.enlazarSiguiente(nuevo);	//al anterior le enlaza el nuevo;
			}else {
				nuevo.enlazarSiguiente(temp); // pone al nuevo antes que el temporal
				if(temp==this.cabeza) {
					this.cabeza=nuevo;	//si no habia anterior al nuevo lo pone como cabeza
				}else {
					anterior.enlazarSiguiente(nuevo);	//si habia anterior le enlaza el nuevo
				}
		}
		}
		size++; 
	}
	
	private void ordenar() {
		Nodo<T>aux= this.cabeza;
		this.cabeza=null;
		while(this.cabeza!=null) {
			this.InsertarOrdenado(aux.obtenerValor());
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
			Nodo<T> temporal = cabeza;
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
		Nodo<T> aux=cabeza;
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
		Nodo<T> aux= this.cabeza;
		while(aux.obtenerValor().equals(valor)&& aux!=null) {
			this.cabeza=cabeza.obtenerSiguiente();	
			size--;
			aux=aux.obtenerSiguiente();
			}
		if(aux!=null) {
			aux=aux.obtenerSiguiente();
		}else {
			cabeza=null;
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
		return new IteradorNodo<T>(this.cabeza);
	}
	
//	public void mostrarLista() {
//		Iterator<T> it = this.iterator();
//		while(it.hasNext()) {
//			T index= it.next();
//		}
//		
//	}
	
	private class IteradorNodo<T> implements Iterator<T>{
		private Nodo<T> nodo;
		
		public IteradorNodo(Nodo<T> n) {
			this.nodo=n;
		}
		@Override
		public boolean hasNext() {
			return nodo.obtenerSiguiente()!=null;
		}
		
		@Override
		public T next() {
			T valor= nodo.obtenerValor();
			nodo = nodo.obtenerSiguiente();
			return valor; 
		}
	}

	
	
	
	
}
