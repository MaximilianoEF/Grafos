package Grafo;

public class Vertice {

	private String nombre;
	private int numVertice;
	
	public Vertice(String x) {
		this.nombre = x;
		this.numVertice = -1;	
	}
	
	/**<RETORNA EL NOMBRE DEL VERTICE>*/
	public String nomVertice() {
		return this.nombre;
	}
	
	/**<COMPARA EL VERTICE ACTUAL CON EL RECIBIDO EN EL PARAMETRO>*/
	public boolean equals(Vertice n) {
		return this.nombre.equals(n.nombre);
	}
	
	/**<ASIGNA AL NUMERO DE VERTICE EL VALOR QUE RECIBE EN EL PARAMETRO>*/
	public void asigVert(int n) {
		this.numVertice = n;
	}
	
}
