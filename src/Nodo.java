

public class Nodo  {
	Object valor;
	Nodo siguiente;  
	
	
	public Nodo (Object valor) {
		this.valor=valor;
	}
	
	public void enlazarSiguiente(Nodo n) {
		siguiente=n;
	}
	
	public Nodo obtenerSiguiente() {
		return siguiente;
	}
	
	public Object obtenerValor() {
		return valor;
	}

}
