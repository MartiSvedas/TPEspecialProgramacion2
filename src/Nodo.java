

public class Nodo<T>  {
	private T valor;
	private Nodo<T> siguiente;  
	
	
	public Nodo (T valor) {
		this.valor=valor;
	}
	
	public void enlazarSiguiente(Nodo<T> n) {
		siguiente=n;
	}
	
	public Nodo<T> obtenerSiguiente() {
		return siguiente;
	}
	
	public T obtenerValor() {
		return valor;
	}

}
