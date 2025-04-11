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
            //não é interesante adicionar um metodo para não permetir que seja gerado uma aresta = origem origem.
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
    //nova linha
    // vai me informar quandos vizinhos cada vertece tem
    public void buscarVizinho(int indice) {
        int cont = 0;
        for (int j = 0; j < vertices.length; j++) {
            if (matrizAdjacente[indice][j] != -1) {
                cont++;
            }
        }
        if (cont > 0) {
            System.out.println("A quantidade de vizinhos do vertece "+vertices[indice]+" é " + cont);
        }else{
            System.out.println("não tem vizinhos");
        }
    }
    // Metodo mostrar vizinhos com base na distancia de forma ordenada
    public void listaOrdenadaVizinho(int indice) {
        //quantidade de vizinhos
        int cont = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (matrizAdjacente[indice][i] != -1) {
                cont++;
            }
        }
        if(cont == 0){
            System.out.println("Não tem vizinhos");
            return;
        }

        //for ordenador de distancias
        int[] distancia = new int[cont];//vou armazenar as distancias
        int[] vizinhos = new int[cont];// indice do vizinho

        int index = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (matrizAdjacente[indice][i] != -1) {
                distancia[index] = matrizAdjacente[indice][i];
                vizinhos[index] = i;
                index++;
            }
        }
        //ordenar as entradas
        for(int i = 0; i < distancia.length -1; i++) {//controle
            for(int j = 0; j < distancia.length -1 -i; j++) {//ordenar a lista
                if(distancia[j] > distancia[j +1]){
                    //troca as distancias
                    int maior = distancia[j];
                    distancia[j] = distancia[j+1];
                    distancia[j+1] = maior;

                    //troca os indices dos vizinhos
                    int maiorVizinho = vizinhos[j];
                    vizinhos[j] = vizinhos[j+1];
                    vizinhos[j+1] = maiorVizinho;
                }
            }
        }
        System.out.println("Vizinhos e suas distâncias (em ordem crescente):");
        for (int i = 0; i < distancia.length; i++) {
            System.out.println("Vizinho: " + vertices[vizinhos[i]] + " - Distância: " + distancia[i]);
        }
    }
}
