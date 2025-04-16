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

    public Vizinho[] getVizinhosOrdenados(int indice) {
        int cont = contarVizinhos(indice);

        if (cont == 0) {
            return new Vizinho[0];
        }

        Vizinho[] vizinhos = new Vizinho[cont];
        int index = 0;

        for (int i = 0; i < vertices.length; i++) {
            if (i != indice && matrizAdjacente[indice][i] != -1) {
                vizinhos[index++] = new Vizinho(vertices[i], matrizAdjacente[indice][i]);
            }
        }

        return vizinhos;
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
