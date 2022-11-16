import java.util.Iterator;

public class Main {
	
    public static void main(String[] args) {
    	
		Nodo<Integer> n1= new Nodo<Integer>(1);
		Nodo<Integer> n2= new Nodo<Integer>(2);
		
		
		Integer elemento100= 100;
			
		ComparadorInteger<Integer> comparadorvalor= new ComparadorInteger<Integer>();
		
		
		ListaVinculada<Integer> listaInteger= new ListaVinculada<Integer>(comparadorvalor);
		listaInteger.InsertarOrdenado(n1.obtenerValor());
		listaInteger.InsertarOrdenado(n2.obtenerValor());
		listaInteger.InsertarOrdenado(elemento100);
		
				
		for(Integer i: listaInteger) {
			System.out.println(i);
		}
//		Iterator<Object> it = listaInteger.iterator();
//			while(it.hasNext()) {
//				Object valor = it.next();
//				System.out.println(valor);
//			}
		
		}
}
