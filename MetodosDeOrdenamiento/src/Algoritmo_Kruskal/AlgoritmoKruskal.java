package Algoritmo_Kruskal;

import Grafo.GrafMatPeso;
import Grafo.Vertice;

public class AlgoritmoKruskal {

	static int INFINITO = 0xFFFF;
	private int[][] matriz;
	private int num_vertices;
	private int[] parent;
	
	/** Vertice origen y numero de vertice*/
	private Vertice[] vertices;
	
	public AlgoritmoKruskal(GrafMatPeso gp, Vertice[] verts) {
		this.num_vertices = gp.numeroDeVertices();
		this.matriz = gp.getMatPeso();
		this.vertices = verts;
		parent = new int[this.num_vertices+1];
	}
	
	protected void recorrer() {
		int i=0, j=0, ne=1, minimo=0, a=0, u=0, b=0, v=0, minimo_costo=0;
	}
	
}
