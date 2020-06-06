package Algoritmo_Prim;

import Grafo.GrafMatPeso;
import Grafo.Vertice;

public class AlgoritmoPrim {

	private int[][] pesos;
	private int n;      /**<vertice origen y numero de vertices>*/
	private Vertice[] vertices;
	private int cont;
	
	public AlgoritmoPrim(GrafMatPeso gp, Vertice[] verts) {
		this.n = gp.numeroDeVertices();
		this.pesos = gp.getMatPeso();
		this.vertices = verts;
		this.cont = 0;
	}
	
	protected int arbolExpansionPrim() {
		int longMin, menor;
		int z;
		int[] coste = new int[this.n];
		int[] masCerca = new int[this.n];
		boolean[] w = new boolean[this.n];
		for(int i=0; i<this.n; i++)
			w[i] = false; //conjunto vacio
		longMin = 0;
		w[0] = true; /*<SE PARTE DEL VERTICE 0>*/
		/**<INICIALMENTE COSTE[I] ES LA ARISTA (0, I)>*/
		for(int i=1; i<this.n; i++) {
			coste[i] = this.pesos[0][i];
			masCerca[i] = 0;
		}
		for(int i=1; i<this.n; i++) {
			/**<Busca vertice z de V-W mas cercano, de menor longitud de arista, a algun vertice de W>*/
			menor = coste[1];
			z = 1;
			for(int j=2; j<this.n; j++) {
				if(coste[j] < menor) {
					menor = coste[j];
					z = j;
				}
			}
			longMin += menor;
			System.out.println((++this.cont)+" Pasada: Vertice: "+this.vertices[masCerca[z]].nomVertice()+" -> "+"Vertice: "
			+this.vertices[z].nomVertice()+" Peso: "+coste[z]);
			w[z] = true; /**<vertice z se añade al conjunto W>*/
			coste[z] = GrafMatPeso.INFINITO;
			/**<Debido a la incorporacion de z, se ajusta coste[] para el resto de vertices>*/
			for(int j=1; j<this.n; j++)
				if((this.pesos[z][j] < coste[j]) && !w[j]) {
					coste[j] = this.pesos[z][j];
					masCerca[j] = z;
				}
		}
		return longMin;
	}
	
}
