import java.util.Iterator;

public class Main {
	
    public static <T> void main(String[] args) {
    	
//		Nodo<Integer> n1= new Nodo<Integer>(1);
//		Nodo<Integer> n2= new Nodo<Integer>(2);
		
		Integer elemento100= 100;
		Integer elemento10=10;
		Integer elemento1=1;
		Integer elemento5=5;
		Integer elemento2=2;
		ComparadorInteger<Integer> comparadorvalor= new ComparadorInteger<Integer>();
		
		
		ListaVinculada<Integer> listaInteger= new ListaVinculada<Integer>(comparadorvalor);
//		listaInteger.InsertarOrdenado(n2.obtenerValor());
//		listaInteger.InsertarOrdenado(n1.obtenerValor());
		
		listaInteger.InsertarOrdenado(elemento1);
		listaInteger.InsertarOrdenado(elemento5);
		listaInteger.InsertarOrdenado(elemento100);
		listaInteger.InsertarOrdenado(elemento10);
		listaInteger.InsertarOrdenado(elemento10);
		listaInteger.InsertarOrdenado(elemento2);
//		listaInteger.eliminarSegunValor(elemento100);
		
		System.out.println("La posicion es " + listaInteger.obtenerPosicion(100));
		
//		listaInteger.eliminarOcurrencias(elemento10);
		
				
		for(Integer i: listaInteger) {
			System.out.println(i);
		}
		
//		Iterator<Integer> it = listaInteger.iterator();
//			while(it.hasNext()) {
//				Integer valor = it.next();
//				System.out.println(valor);
//			}
		
		}
}
