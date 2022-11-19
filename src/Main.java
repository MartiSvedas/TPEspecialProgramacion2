import java.util.Comparator;
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
//		ComparadorInverso<Integer> comparadorinverso = new ComparadorInverso<Integer>(comparadorvalor);
		
		ListaVinculada<Integer> listaInteger= new ListaVinculada<Integer>(comparadorvalor);
//		listaInteger.insertarOrdenado(n2.obtenerValor());
//		listaInteger.insertarOrdenado(n1.obtenerValor());
		
		listaInteger.insertarOrdenado(elemento1);
		listaInteger.insertarOrdenado(elemento1);
		listaInteger.insertarOrdenado(elemento1);
		listaInteger.insertarOrdenado(elemento1);
		listaInteger.insertarOrdenado(elemento1);
		listaInteger.insertarOrdenado(elemento5);
		listaInteger.insertarOrdenado(elemento100);
		listaInteger.insertarOrdenado(elemento100);
		listaInteger.insertarOrdenado(elemento10);
		listaInteger.insertarOrdenado(elemento10);
		listaInteger.insertarOrdenado(elemento2);
		listaInteger.insertarOrdenado(elemento2);
	
//		listaInteger.eliminarSegunValor(elemento100);
		
//		listaInteger.insertar(elemento100);
//		listaInteger.insertar(elemento1);
//		listaInteger.insertar(elemento10);
//		listaInteger.insertar(elemento2);
//		listaInteger.insertar(elemento1);

//		listaInteger.setOrden(comparadorvalor);

		
//		System.out.println("La posicion es " + listaInteger.obtenerPosicion(5));
		
		listaInteger.eliminarOcurrencias(elemento100);
		
				
		for(Integer i: listaInteger) {
			System.out.println(i);
		}
		
//		Iterator<Integer> it = listaInteger.iterator();
//			while(it.hasNext()) {
//				Integer valor = it.next();
//				System.out.println(valor);
//			}
		
//		ComparadorString<String> comparadorString= new ComparadorString<String>();
//		
//		ListaVinculada<String> listaString= new ListaVinculada<String> (comparadorString);
//		
//		String elementoFacil= "Facil";
//		String elementoEs = "Es";
//		String elementoParcial="Parcial";
//		String elementoPro2= "Pro2";
//		
//		listaString.insertar(elementoFacil);
//		listaString.insertar(elementoEs);
//		listaString.insertar(elementoParcial);
//		listaString.insertar(elementoPro2);

//		System.out.println("La palabra 'parcial' se encuentra en la posicion "+ listaString.obtenerPosicion(elementoParcial));
		
//		ComparadorInverso<String> comparadorinversoSt = new ComparadorInverso<String>(comparadorString);
		
//		listaString.setOrden(comparadorinversoSt);
		
//		for(String i: listaString) {
//			System.out.println(i);
//		}
		

		
		
		}
}
