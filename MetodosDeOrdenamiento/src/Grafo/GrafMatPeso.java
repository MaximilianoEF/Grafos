package Grafo;

public class GrafMatPeso {

	public static int INFINITO = 0xFFFF;
	private int [][] matPeso;
	private Vertice [] verts;
	private int numVerts;
	
	public GrafMatPeso(int mx) {
		this.matPeso = new int[mx][mx];
		this.verts = new Vertice[mx];
		for(int i=0; i<mx; i++)
			for(int j=0; j<mx; j++)
				matPeso[i][j] = INFINITO;
		this.numVerts = 0;
	}
	
	/**<CREA UN NUEVO VERTICE RECIBIENDO SU NOMBRE DE PARAMETRO>*/
	public void nuevoVertice(String nom) {
		boolean esta = this.numVerts >= 0;
		if(!esta) {
			Vertice v = new Vertice(nom);
			v.asigVert(this.numVerts);
			this.verts[numVerts++] = v;
		}
	}
	
	/**<RETORNA EL VALOR DEL PESO ENTRE LAS ARISTAS INGRESADAS>*/
	public int pesoArista(String a, String b) {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		return this.matPeso[va][vb];
	}
	
	/**<RETORNA EL NUMERO DEL VERTICE>*/
	public int numeroDeVertices() {
		return this.numVerts;
	}
	
	/**<RETORNA EL ARRAY DE VERTICES>*/
	public Vertice[] vertices() {
		return this.verts;
	}
	
	/**<CREA UNA NUEVA ARISTA ENTRE DOS VERTICES CON UN PESO ESPECIFICADO EN LOS PARAMETROS>*/
	public void nuevaArista(String a, String b, int peso) {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		this.matPeso[va][vb] = peso;
	}
	
	/**<VALIDA QUE EXISTA EL VERTICE CON EL NOMBRE QUE RECIBE EN EL PARAMETRO>*/
	public int numVertice(String vs) {
		Vertice v = new Vertice(vs);
		boolean encontrado = false;
		int i = 0;
		for(; (i<this.numVerts) && !encontrado;) {
			encontrado = verts[i].equals(v);
			if(!encontrado) i++;
		}
		return (i<this.numVerts) ?i : -1;
	}
	
	/**<RETORNA LA MATRIZ DE PESO>*/
	public int[][] getMatPeso(){
		return this.matPeso;
	}
	
}
