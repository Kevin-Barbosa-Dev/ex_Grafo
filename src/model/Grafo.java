package model;

import java.util.Scanner;

public class Grafo {

   private int[][] matrizAdjacente;
    private String[] vertices;
    private int tamanho;

    // Construtor que inicializa a matriz de adjacência
    public Grafo(int tamanho) {
        this.tamanho = tamanho;
        matrizAdjacente = new int[this.tamanho][this.tamanho];
        vertices = new String[this.tamanho];

        // Inicializa a matriz com -1 (indica que não há conexão entre os vértices)
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                matrizAdjacente[i][j] = -1;
            }
        }
    }

    // Método para adicionar um vértice ao grafo
    public void adicionarVertice(int indice, String nome) {
        if (indice >= 0 && indice < vertices.length) {
            vertices[indice] = nome;
        }
    }

    // Método para adicionar uma aresta com uma distância entre dois vértices
    public void adicionarAresta(int origem, int destino, int distancia) {
        if (origem >= 0 && origem < matrizAdjacente.length && destino >= 0 && destino < matrizAdjacente.length) {
            matrizAdjacente[origem][destino] = distancia;
            matrizAdjacente[destino][origem] = distancia; // Para grafo não-direcionado
        }
    }

    // Método para exibir a matriz de adjacência
    public void exibirMatrizAdjacente() {
        System.out.println("Matriz de Adjacência:");
        System.out.print("     ");
        for (int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i] + "   ");
        }
        System.out.println();

        for (int i = 0; i < matrizAdjacente.length; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < matrizAdjacente[i].length; j++) {
                if (matrizAdjacente[i][j] == -1) {
                    System.out.print(" - ");
                } else {
                    System.out.print(matrizAdjacente[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public void buscarVizinhos(int quantidadesDeVizinhos) {
        int qunt = 0;
        for (int i = 0; i < matrizAdjacente[quantidadesDeVizinhos].length; i++) {
            if (matrizAdjacente[quantidadesDeVizinhos][i] != -1 && quantidadesDeVizinhos != i) {
                qunt++;
            }

        }
        System.out.println("O vértice " + vertices[quantidadesDeVizinhos] + " tem " + qunt + " vizinhos.");
    }


}
