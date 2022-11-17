import java.util.Comparator;
import java.util.Iterator;

public class ListaVinculada<T> implements Iterable<T>{
	
	Nodo<T> cabeza;
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
				anterior = temp;		//al anterior le doy el papel de cabeza
				temp=temp.obtenerSiguiente(); //avanzo		
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
		while(aux!=null) {
			this.InsertarOrdenado(aux.obtenerValor());
			aux=aux.obtenerSiguiente();
		}
		
	}
	
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
	
	  public void eliminarSegunValor(T numeroAeliminar) {
	        if (cabeza!= null) {
	            Nodo<T> actual = cabeza;
	            Nodo<T> anterior = null;
	            while ((actual != null) && (!actual.obtenerValor().equals(numeroAeliminar))) {
	                anterior = actual;
	                actual = actual.obtenerSiguiente();
	            }
	            if (actual==cabeza){
	                cabeza=actual.obtenerSiguiente();
	            }else if ((actual != null) && (actual.obtenerValor().equals(numeroAeliminar))) {
	                anterior.enlazarSiguiente(actual.obtenerSiguiente());
	                this.size--;
	            }
	        }

	    }
	
	public Object obtenerValor(Integer index) {
		int contador =0;
		Nodo<T> temp= cabeza;
		while(contador<index ) {
			
			temp= temp.obtenerSiguiente();
			contador ++;
		}
		return temp.obtenerValor();
	}
	
	public Integer obtenerPosicion(T valor) {
		if(estaVacia()) {
			return null;
		}else {
		Nodo<T> aux=cabeza;
		int contador=0;
		while(aux!=null && aux.obtenerValor()!=valor) {
			aux=aux.obtenerSiguiente();
			contador++;
		}
			return contador;
		}
	}
	
	public void eliminarOcurrencias(T valor) {
		if(estaVacia()) {
			return ;
		}else {	
		Nodo<T> aux= this.cabeza;
		Nodo<T> ant=null;
		while(aux.obtenerValor().equals(valor)&& aux!=null) {//recorro la lista 
			this.cabeza=cabeza.obtenerSiguiente();	
			size--;
			aux=aux.obtenerSiguiente();
			}
		if(aux!=null) { 
			ant=aux;	
			aux=aux.obtenerSiguiente();
		}else {
			cabeza=null;
		 
		}
		while(aux!=null) {
			if(aux.obtenerValor().equals(valor)) {
				ant.enlazarSiguiente(aux.obtenerSiguiente()); //apunto al nodo siguiente al siguiente(elimino)
				aux=aux.obtenerSiguiente(); //avanzo
				this.size--;
			}else {
				ant=aux; 
				aux=aux.obtenerSiguiente();
			}
		}
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
	
	public void mostrarLista() {
        IteradorNodo<T> iterador = new IteradorNodo<T>(cabeza, size);
        while(iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
	
	public Iterator<T> iterator(){
		return new IteradorNodo<T>(this.cabeza,this.size);
	}
	
	private class IteradorNodo<T> implements Iterator<T>{
		private Nodo<T> nodo;
		private int pos;
		
		public IteradorNodo(Nodo<T> n, int pos) {
			this.nodo=n;
			this.pos=pos;
		}
		
		@Override
		public boolean hasNext() {
			return pos>0 ;
		}
		

		@Override
		public T next() {
			pos--;
			T valor= nodo.obtenerValor();
			nodo = nodo.obtenerSiguiente();
			return valor; 
		}
	}

	
	
	
	
}
