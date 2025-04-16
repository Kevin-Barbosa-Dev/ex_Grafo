package model;

public class Grafo {

    private float[][] matrizAdjacente;
    private String[] vertices;
    private int tamanho;

    public Grafo(int capacidade) {
        this.tamanho = 0;
        matrizAdjacente = new float[capacidade][capacidade];
        vertices = new String[capacidade];

        // Inicializa a matriz com -1 (indica que não há conexão entre os vértices)
        for (int i = 0; i < capacidade; i++) {
            for (int j = 0; j < capacidade; j++) {
                matrizAdjacente[i][j] = -1;
            }
        }
    }

    public void adicionarVertice(int indice, String nome) {

        if (indice >= 0 && indice < vertices.length) {
            vertices[indice] = nome;
            tamanho++;
        }
    }

    public void adicionarAresta(int origem, int destino, float distancia) { // Alterado para float
        if (origem >= 0 && origem < matrizAdjacente.length && destino >= 0 && destino < matrizAdjacente.length) {
            matrizAdjacente[origem][destino] = distancia;
            matrizAdjacente[destino][origem] = distancia;
        }
    }

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

    public int contarVizinhos(int indice) {
        int cont = 0;
        for (int j = 0; j < vertices.length; j++) {
            if (j != indice && matrizAdjacente[indice][j] != -1) {
                cont++;
            }
        }
        return cont;
    }

    public void listaOrdenadaVizinho(int indice) {
        int cont = contarVizinhos(indice);

        float[] distancia = new float[cont];
        int[] vizinhos = new int[cont];

        int index = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (matrizAdjacente[indice][i] != -1) {
                distancia[index] = matrizAdjacente[indice][i];
                vizinhos[index] = i;
                index++;
            }
        }

        for (int i = 0; i < distancia.length - 1; i++) {
            for (int j = 0; j < distancia.length - 1 - i; j++) {
                if (distancia[j] > distancia[j + 1]) {
                    // troca as distancias
                    float maior = distancia[j];
                    distancia[j] = distancia[j + 1];
                    distancia[j + 1] = maior;

                    // troca os indices dos vizinhos
                    int maiorVizinho = vizinhos[j];
                    vizinhos[j] = vizinhos[j + 1];
                    vizinhos[j + 1] = maiorVizinho;
                }
            }
        }
        System.out.println("Vizinhos e suas distâncias (em ordem crescente):");
        for (int i = 0; i < distancia.length; i++) {
            System.out.println("Vizinho: " + vertices[vizinhos[i]] + " - Distância: " + distancia[i]);
        }
    }

    public String[] getVertices() {
        return vertices;
    }

    public float[][] getMatrizAdjacente() {
        return matrizAdjacente;
    }

    public int getTamanho() {
        return tamanho;
    }

}
