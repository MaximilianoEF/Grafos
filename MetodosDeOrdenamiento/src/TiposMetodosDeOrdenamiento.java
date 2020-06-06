
public class TiposMetodosDeOrdenamiento {

	public int [] burbujeo(int [] arreglo) {
		int auxiliar;
	      int[] arregloOrdenado;
	      for(int i = 2; i < arreglo.length; i++)
	      {
	        for(int j = 0;j < arreglo.length-i;j++)
	        {
	          if(arreglo[j] > arreglo[j+1])
	          {
	            auxiliar = arreglo[j];
	            arreglo[j] = arreglo[j+1];
	            arreglo[j+1] = auxiliar;
	          }   
	        }
	      }
	      arregloOrdenado = arreglo;
	      return arregloOrdenado;
	}
	
	
	
	public static void insercionDirecta(int A[]){
	    int p, j;
	    int aux;
	    for (p = 1; p < A.length; p++){ // desde el segundo elemento hasta
	              aux = A[p]; // el final, guardamos el elemento y
	              j = p - 1; // empezamos a comprobar con el anterior
	              while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el
	                                                                    // valor de aux sea menor que los
	                             A[j + 1] = A[j];       // de la izquierda, se desplaza a
	                             j--;                   // la derecha
	              }
	              A[j + 1] = aux; // colocamos aux en su sitio
	    }
	}




	public static void seleccion(int A[]) {
          int i, j, menor, pos, tmp;
          for (i = 0; i < A.length - 1; i++) { // tomamos como menor el primero
                menor = A[i]; // de los elementos que quedan por ordenar
                pos = i; // y guardamos su posición
                for (j = i + 1; j < A.length; j++){ // buscamos en el resto
                      if (A[j] < menor) { // del array algún elemento
                          menor = A[j]; // menor que el actual
                          pos = j;
                      }
                }
                if (pos != i){ // si hay alguno menor se intercambia
                    tmp = A[i];
                    A[i] = A[pos];
                    A[pos] = tmp;
                }
          }
}

	
	public static class MetodosDeBusqueda {
		
		public static  int [] burbujeo(int [] arreglo) {
			int auxiliar;
		      int[] arregloOrdenado;
		      for(int i = 2; i < arreglo.length; i++)
		      {
		        for(int j = 0;j < arreglo.length-i;j++)
		        {
		          if(arreglo[j] > arreglo[j+1])
		          {
		            auxiliar = arreglo[j];
		            arreglo[j] = arreglo[j+1];
		            arreglo[j+1] = auxiliar;
		          }   
		        }
		      }
		      arregloOrdenado = arreglo;
		      return arregloOrdenado;
			
			
		}
		
		public static int [] insercionDirecta(int A[]){
		    int p, j;
		    int aux;
		    for (p = 1; p < A.length; p++){ // desde el segundo elemento hasta
		              aux = A[p]; // el final, guardamos el elemento y
		              j = p - 1; // empezamos a comprobar con el anterior
		              while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el
		                                                                    // valor de aux sea menor que los
		                             A[j + 1] = A[j];       // de la izquierda, se desplaza a
		                             j--;                   // la derecha
		              }
		              A[j + 1] = aux; // colocamos aux en su sitio
		    }
			return A;
		}
		
		//método java de ordenación por selección
		public static int []  seleccion(int A[]) {
		          int i, j, menor, pos, tmp;
		          for (i = 0; i < A.length - 1; i++) { // tomamos como menor el primero
		                menor = A[i]; // de los elementos que quedan por ordenar
		                pos = i; // y guardamos su posición
		                for (j = i + 1; j < A.length; j++){ // buscamos en el resto
		                      if (A[j] < menor) { // del array algún elemento
		                          menor = A[j]; // menor que el actual
		                          pos = j;
		                      }
		                }
		                if (pos != i){ // si hay alguno menor se intercambia
		                    tmp = A[i];
		                    A[i] = A[pos];
		                    A[pos] = tmp;
		                }
		          }
				return A;
		}
		
		//METODO SHELL SHORT
				public static void shellSort(int[] matrix) {
				    for ( int increment = matrix.length / 2;increment > 0;
				          increment = (increment == 2 ? 1 : (int) Math.round(increment / 2.2))) {
				        for (int i = increment; i < matrix.length; i++) {
				            for (int j = i; j >= increment && matrix[j - increment] > matrix[j]; j -= increment) {
				                int temp = matrix[j];
				                matrix[j] = matrix[j - increment];
				                matrix[j - increment] = temp;
				            }
				        }
				    }
				}

		//ORDENAMIENTO POR MEZCLAS (MERGE)
		//El algoritmo de ordenamiento por mezcla (Merge) se divide en dos procesos, primero se divide en partes iguales la lista:
				public static void mergesort(int[ ] matrix, int init, int n){
				   int n1;
				   int n2;
				   if (n > 1){
				      n1 = n / 2;
				      n2 = n - n1;
				      mergesort(matrix, init, n1);
				      mergesort(matrix, init + n1, n2);
				      merge(matrix, init, n1, n2);
				 }
		}
				
		//Y el algoritmo que nos permite mezclar los elementos según corresponda:
			private static void merge(int[ ] matrix, int init, int n1, int n2){
				  int[ ] buffer = new int[n1+n2];
				  int temp = 0;
				  int temp1 = 0;
				  int temp2 = 0;
				  int i;
				  while ((temp1 < n1) && (temp2 < n2)){
				      if (matrix[init + temp1] < matrix[init + n1 + temp2]){
				          buffer[temp++] = matrix[init + (temp1++)];
				      }else{
		            buffer[temp++] = matrix[init + n1 + (temp2++)];
				      }
		    }
				  while (temp1 < n1){
			        buffer[temp++] = matrix[init + (temp1++)];
		    }
				  while (temp2 < n2){
				    buffer[temp++] = matrix[init + n1 + (temp2++)];
		   }
				  for (i = 0; i < n1+n2; i++){
				       matrix[init + i] = buffer[i];
				  }
		}

		//ORDENAMIENTO RAPIDO
		public static void Rapido(int matrix[], int a, int b){
			matrix = new int[matrix.length];
			int buf;
		    int from = a;
		    int to = b;
		    int pivot = matrix[(from+to)/2];
		    do{
		        while(matrix[from] < pivot){
		            from++;
		        }
		        while(matrix[to] > pivot){
		            to--;
		        }
		        if(from <= to){
		            buf = matrix[from];
		            matrix[from] = matrix[to];
		            matrix[to] = buf;
		            from++; to--;
		        }
		    }while(from <= to);
		    if(a < to){
		        Rapido(matrix, a, to);
		    }
		    if(from < b){
		        Rapido(matrix, from, b);
		    }
		}

		
		public static void medirTiempoEjecucion(int [] vectorAComparar) {

				  long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
				  long TInicio2, TFin2, tiempo2;
				  long TInicio3, TFin3, tiempo3;
				//burbujeo
				  TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
				
				  burbujeo(vectorAComparar);

				TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
				  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
				 
			//seleccion
				  TInicio2 = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
					
				  seleccion(vectorAComparar);

				  TFin2 = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
				  tiempo2 = TFin2 - TInicio2; //Calculamos los milisegundos de diferencia
				  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo2); //Mostramos en pantalla el tiempo de ejecución en milisegundos
				 
			//insercionDirecta
				  
				  TInicio3 = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
					
				  insercionDirecta(vectorAComparar);

				  TFin3 = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
				  tiempo3 = TFin3 - TInicio3; //Calculamos los milisegundos de diferencia
				  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo3); //Mostramos en pantalla el tiempo de ejecución en milisegundos
				 
				  if(tiempo>tiempo2 && tiempo>tiempo3) {
					  
					  System.out.println("el mejor metodo de busqueda es burbujeo");
				  }else if(tiempo2>tiempo && tiempo2>tiempo3) {
					  System.out.println("el mejor metodo de busqueda es seleccion");
				  }else {
					  System.out.println("el mejor metodo de busqueda es insercion Directa");
				  }
			
		}

	} 

		/*COMPLEJIDAD
		Cada algoritmo de ordenamiento por definición tiene operaciones y cálculos mínimos y máximos que realiza (complejidad), a continuación una tabla que indica la cantidad de cálculos que corresponden a cada método de ordenamiento:

		Algoritmo
		Operaciones máximas
		Burbuja
		(n2)
		Inserción
		(n2/4)
		Selección
		(n2)
		Shell
		(n log2n)
		Merge
		(n logn)
		Quick
		(n2) en peor de los casos y (n logn) en el promedio de los casos.*/
	
}
