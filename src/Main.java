import java.util.Iterator;

public class Main {
	
    public static void main(String[] args) {
    	
		Nodo n1= new Nodo(1);
		Nodo n2= new Nodo(2);
			
		Comparador<Integer> comparadorvalor= new ComparadorValor<Integer>();
		
		
		ListaVinculada<Integer> listaInteger= new ListaVinculada<Integer>(comparadorvalor);
		listaInteger.InsertarOrdenado(n1.obtenerValor());
		listaInteger.InsertarOrdenado(n2.obtenerValor());
					
		Iterator<Integer> it = listaInteger.iterator();
			while(it.hasNext()) {
				Object valor = it.next();
				System.out.println(valor);
			}
		
		}
}
