//Algoritmo "BFS" de grafos. Este algoritmo realiza una búsqueda en anchura por el grafo.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AlgoritmoBFS {

	private int cantidadNodos;
	private int cantidadAristas;
	private int[][] matrizAdyacencia;
	private int[] estado;
	private int[] distancia;
	private int[] padre;
	private final int VISITADO = 1;
	private final int NOVISITADO = 0;
	private LinkedList cola = new LinkedList();
	
	
	public AlgoritmoBFS(Scanner entrada) {
		int nodo1, nodo2;
		this.cantidadNodos = entrada.nextInt();
		this.cantidadAristas = entrada.nextInt();
		this.estado = new int[this.cantidadNodos];
		this.distancia = new int[this.cantidadNodos];
		this.padre = new int[this.cantidadNodos];
		Arrays.fill(distancia, Integer.MAX_VALUE);
		Arrays.fill(estado, NOVISITADO);
		Arrays.fill(padre, 0);
		this.matrizAdyacencia = new int[this.cantidadNodos][this.cantidadNodos];
		for(int[] row : matrizAdyacencia)
			Arrays.fill(row, 0);
		for(int i=0; i<this.cantidadAristas; i++) {
			nodo1 = entrada.nextInt();
			nodo2 = entrada.nextInt();
			this.matrizAdyacencia[nodo1][nodo2] = 1;
		}
	}
	
	public void realizarBFS(int nodoOrigen) {
		int nodoU;
		this.estado[nodoOrigen] = VISITADO;
		this.distancia[nodoOrigen] = 0;
		this.cola.offer(nodoOrigen);
		while(this.cola.isEmpty() == false) {
			nodoU = (int) this.cola.poll();
			for(int i=0; i<this.cantidadNodos; i++) {
				if(i != nodoU && this.matrizAdyacencia[nodoU][i] != 0) {
					if(this.estado[i] == NOVISITADO) {
						this.estado[i] = VISITADO;
						this.distancia[i] = this.distancia[nodoU] + 1;
						this.padre[i] = nodoU;
						this.cola.offer(i);
					}
				}
			}
		}
	}
	
	public void mostrarVectores() {
		System.out.println("Estados: ");
		for (int estado : this.estado) {
			System.out.print(estado + " ");
		}
		System.out.println('\n' + "Distancias: ");
		for (int distancia : this.distancia) {
			System.out.print(distancia + " ");
		}
		System.out.println('\n' + "Padres: ");
		for (int padre : this.padre) {
			System.out.print(padre + " ");
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner entrada = new Scanner(new FileReader("bfs.in"));
		AlgoritmoBFS bfs = new AlgoritmoBFS(entrada);
		entrada.close();
		bfs.realizarBFS(0);
		bfs.mostrarVectores();
	}
	
}