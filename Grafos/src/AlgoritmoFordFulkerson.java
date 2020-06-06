
public class AlgoritmoFordFulkerson {

	/**
     * Implementacion del algoritmo Ford-Fulkerson para determinar el flujo maximo de una red de Grafos dirigidos.
     *
     * @return El flujo maximo entre la fuente y el sumidero de la red.
     * @throws IllegalStateException En caso de no ser valida la red.
     */
    public int algoritmoFordFulkerson() throws IllegalStateException{
		return 0;
        /**
         * Algoritmo Ford-Fulkerson, con busqueda Depth-First.
         */

        //La red debe ser valida
       /* if(!redEsValida())
            throw new IllegalStateException("Red invalida");

        //Flujo maximo de la red
        int flujoMaximo = 0;
        Vertice origen = encontrarFuente();
        Vertice sumidero = encontrarSumidero();
        //Camino desde Origen a Sumidero
        List<Vertice> caminoVertice;

        setAristasFlujoCero();                                              //1- Establecer a 0 el flujo de todas las aristas
        while ((caminoVertice = existeCamino(origen, sumidero)) != null){   //2- Mientras exista un camino entre el Origen y el Sumidero
            List<Arista> camino = caminoEntreVertices(caminoVertice);
            int flujoMenor = camino.stream()                                //3- Para cada Arista del camino ...
                    .mapToInt(Arista::getFlujoRestante)                     //   .. se toma el flujo que puede aumentar ..
                    .min()                                                  //   .. el menor flujo ..
                    .getAsInt();                                            //   .. se guarda.

            camino.forEach((Arista e) -> e.setFlujo(e.getFlujo() + flujoMenor)); //4- Se aumenta el flujo en cada Arista del camino en esa cantidad
            flujoMaximo += flujoMenor;                                           //5- Esta cantidad se suma al flujo maximo.
        }

        return flujoMaximo;*/
    }
	
}
