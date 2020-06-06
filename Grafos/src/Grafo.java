
import java.util.*;

/* 
 * Esta clase modela y gestiona un grafo no dirigido
 * usando una estructura de listas para representar
 * las adyacencias. Adem�s contiene m�todos para
 * gestionar v�rtices y aristas.
 * Los v�rtices se distinguen por su etiqueta.
 * Un par de v�rtices solo permite una arista entre ellos
 */

public class Grafo{

    private HashMap<String, Vertice> vertices;
    private HashMap<Integer, Arista> aristas;

    /**
     * Construcci�n de un grafo vac�o
     **/
    public Grafo()
    {
	this.vertices = new HashMap<String, Vertice>();
	this.aristas = new HashMap<Integer, Arista>();
    }


    /**
     * Construcci�n de un grafo que acepta una lista
     * de vertices por par�metro de entrada
     *
     *@param vertices. Array de lista usado para llenar el grafo
     **/
    public Grafo(ArrayList<Vertice> vertices)
    {
	this.vertices = new HashMap<String, Vertice>();
	this.aristas = new HashMap<Integer, Arista>();

	for(Vertice v : vertices )
	    {
		this.vertices.put(v.getEtiqueta(), v);
	    }
	
    }


    /**
     * Inserta una arista unitaria entre los vertices v1 y v2
     * si y solo si no exista ya una arista que los una
     *
     * @param v1. Un extremo de la arista
     * @param v2. Otro extremo de la arista
     * @return true. Si y solo si la arista no existe previamente
     **/
    public boolean insertarArista(Vertice v1, Vertice v2)
    {
      	return insertarArista(v1, v2, 1);
    }

    
    /**
     * Inserta una arista entre los vertices v1 y v2
     * y un coste o peso especificado por par�metro de entrada. 
     * La arista se insertar� con �xito siempre que sea �nica y adem�s
     * no haya otra uniendo actualmente v1 y v2. Finalmente v1 y v2 no
     * deben ser el mismo v�rtice (v1 != v2)
     *
     * @param v1. Un extremo de la arista
     * @param v2. Otro extremo de la arista
     * @param peso. Coste para llegar de v1 a v2 o viceversa
     * @return true. Si y solo si la arista no existe previamente
     **/
    public boolean insertarArista(Vertice v1, Vertice v2, int peso)
    {
	if(v1.equals(v2)) //vertices identicos?
	    return false;

	Arista arista = new Arista(v1, v2, peso);

	if(aristas.containsKey(arista.hashCode())) //arista ya est� en el grafo?
	    return false;
	else if( v1.contieneUnVecino(arista) || v2.contieneUnVecino(arista)) //arista ya une a v1 o v2?
	    return false;

	aristas.put(arista.hashCode(), arista);
	v1.insertarVecino(arista);
	v2.insertarVecino(arista);
	return true;
    }

    /** 
     * @param arista. Arista que estamos buscando
     * @return true. Si y solo si el grafo contiene a la arista
     **/
    public boolean contieneLaArista(Arista arista)
    {
	if(arista.getVertice1() == null || arista.getVertice2() == null)
	    return false;
	return this.aristas.containsKey(arista.hashCode());
    }


    /**
     * Elimina una arista del grafo. Por tanto, los vertices que un�an
     * pierden la adyacencia entre ellos
     *
     *@param arista. Arista que se quiere eliminar del grafo
     *@return Arista. Arista borrada del grafo
     */
    public Arista eliminarArista(Arista arista)
    {
	arista.getVertice1().eliminarVecino(arista);
	arista.getVertice2().eliminarVecino(arista);
	return this.aristas.remove(arista.hashCode());
    }

    /**
     * Nos devuelve true si encuentra el v�rtice que se pasa
     * como par�metro de entrada
     * 
     * @param vertice. V�rtice que buscamos
     * @return boolean. True si el vertice se encuentra.
     **/    
    public boolean contieneElVertice(Vertice vertice)
    {
	return (this.vertices.get(vertice.getEtiqueta()) != null);
    }

    /**
     * @param etiqueta. Distintivo de cada v�rtice
     * @return Vertice. Devuelve el v�rtice asociado a la etiqueta
     **/
    public Vertice getVertice(String etiqueta)
    {
	return this.vertices.get(etiqueta);
    }

    /**
     * Inserta un nuevo v�rtice. Si el v�rtice existe previamente entonces
     * se consulta si puede ser sobreescrito. En tal caso se elimina las adyacencias
     * existentes.
     *
     * @param vertice. V�rtice a insertar
     * @param sobreescribeVertice. Permiso para sobreescribir el v�rtice
     * @return boolean. Verdarero si el v�rtice se inserta con �xito
     **/
    public boolean insertarVertice(Vertice vertice, boolean sobreescribeVertice)
    {
	Vertice actual = this.vertices.get(vertice.getEtiqueta());
	if(actual != null) //exist�a previamente?
	    {
		if(!sobreescribeVertice)
		    return false;

		while(actual.getContarVecinos() >= 0)
		    this.eliminarArista(actual.getVecino(0));
		
	    }

	vertices.put(vertice.getEtiqueta(), vertice);
	return true;
    }

    /**
     * Elimina el v�rtice especificado mediante la etiqueta
     * distintiva por par�metro de entrada. Al eliminar el v�rtice
     * se elimina tambi�n todas las adyancencias que pose�a este.
     *
     * @param etiqueta. Cadena distintiva de cada v�rtice
     * @return Vertice. Devuelve el v�rtice eliminado
     **/
    public Vertice eliminarVertice(String etiqueta)
    {
	Vertice vertice = vertices.remove(etiqueta);

	while(vertice.getContarVecinos() >= 0)
	    this.eliminarArista(vertice.getVecino(0));

	return vertice;
    }

    /**
     * @return Set<String>. Devuelve las etiquetas, que son el distintivo
     * �nico de cada objeto Vertice en el Grafo
     **/
    public Set<String> verticeKeys()
    {
	return this.vertices.keySet();
    }

    /**
     * @return Set<Arista>. Devuelve todos los objetos Arista del Grafo
     **/
    public Set<Arista> getAristas()
    {
	return new HashSet<Arista>(this.aristas.values());
    }
    
}