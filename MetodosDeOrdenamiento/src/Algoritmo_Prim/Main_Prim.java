package Algoritmo_Prim;

import Grafo.GrafMatPeso;

public class Main_Prim {

	public static void main(String[] args) {
		/**NUMERO DE VERTICES*/
		int n = 7;
		
		/**INSTANCIAMOS EL OBJETO QUE CONTENDRA AL GRAFO*/
		GrafMatPeso gra = new GrafMatPeso(n);
		
		/**NOMBRE DE LAS ARISTAS*/
		String a = "A";
		String b = "B";
		String c = "C";
		String d = "D";
		String e = "E";
		String f = "F";
		String g = "G";
		
		/**CREAMOS LOS VERTICES*/
		gra.nuevoVertice(a);
		gra.nuevoVertice(b);
		gra.nuevoVertice(c);
		gra.nuevoVertice(d);
		gra.nuevoVertice(e);
		gra.nuevoVertice(f);
		gra.nuevoVertice(g);
		
		/**REALIZAMOS LOS ENLACES(NODO_INICIAL, NODO_FINAL, PESO)*/
		gra.nuevaArista(a, b, 7);
		gra.nuevaArista(b, a, 7);
		gra.nuevaArista(a, d, 5);
		gra.nuevaArista(d, a, 5);
		gra.nuevaArista(b, c, 8);
		gra.nuevaArista(c, b, 8);
		gra.nuevaArista(b, d, 9);
		gra.nuevaArista(d, b, 9);
		gra.nuevaArista(b, e, 7);
		gra.nuevaArista(e, b, 7);
		gra.nuevaArista(e, c, 5);
		gra.nuevaArista(c, e, 5);
		gra.nuevaArista(e, d, 15);
		gra.nuevaArista(d, e, 15);
		gra.nuevaArista(d, f, 6);
		gra.nuevaArista(f, d, 6);
		gra.nuevaArista(e, f, 8);
		gra.nuevaArista(f, e, 8);
		gra.nuevaArista(e, g, 9);
		gra.nuevaArista(g, e, 9);
		gra.nuevaArista(f, g, 11);
		gra.nuevaArista(g, f, 11);
		
		/**IMPRIMIR LOS VERTICES EXISTENTES EN EL GRAFO*/
		System.out.println("Vertices del grafo: ");
		for(int i=0; i<n; i++) {
			System.out.println(gra.vertices()[i].nomVertice()+" ");
		}
		System.out.println();
		
		/**INSTANCIAMOS EL OBJETO ArbolExpansionMinimo*/
		AlgoritmoPrim arbol = new AlgoritmoPrim(gra, gra.vertices());
		System.out.println("Costo del arbol minimo: "+arbol.arbolExpansionPrim());
	}
	
}
