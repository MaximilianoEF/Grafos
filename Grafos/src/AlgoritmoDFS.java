//Algoritmo "DFS" de grafos. Este algoritmo realiza una búsqueda en profundidad por el grafo.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class AlgoritmoDFS {

	private int cantidadNodos;
	private int cantidadAristas;
	private boolean[][] matrizAdyacencia;
	private Stack<Integer> pila = new Stack();
	private boolean[] estado; 
	
	public AlgoritmoDFS(Scanner entrada) {
		int nodo1, nodo2;
		this.cantidadNodos = entrada.nextInt();
		this.cantidadAristas = entrada.nextInt();
		this.estado = new boolean[this.cantidadNodos];
		Arrays.fill(estado, false);
		this.matrizAdyacencia = new boolean[this.cantidadNodos][this.cantidadNodos];
		for(boolean[] row : matrizAdyacencia)
			Arrays.fill(row, false);
		for(int i=0; i<this.cantidadAristas; i++) {
			nodo1 = entrada.nextInt();
			nodo2 = entrada.nextInt();
			this.matrizAdyacencia[nodo1][nodo2] = true;
		}
	}
	
	public void calcularDFS(int nodoOrigen) {
		int nodoU;
		this.estado[nodoOrigen] = true;
		this.pila.push(nodoOrigen);
		while(this.pila.isEmpty() == false) {
			nodoU = this.pila.pop();
			for(int i=0; i<this.cantidadNodos; i++) {
				if(i != nodoU && this.matrizAdyacencia[nodoU][i] != false) {
					if(this.estado[i] == false) {
						estado[i] = true;
						this.pila.push(i);
					}
				}
			}
		}
	}
	
	public void mostrarVector() {
		System.out.println("Estados: ");
		for (boolean estado : estado) {
			System.out.print(estado + " ");
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner entrada = new Scanner(new FileReader("dfs.in"));
		AlgoritmoDFS dfs = new AlgoritmoDFS(entrada);
		entrada.close();
		dfs.calcularDFS(0);
		dfs.mostrarVector();
	}

}
