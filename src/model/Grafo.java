package model;

import java.util.Scanner;

public class Grafo {

    private int[][] matriz;


    public  Grafo(int numeroDeVerteces) {
        matriz = new int[numeroDeVerteces][numeroDeVerteces];


    }

    public void adicionar(int origem, int destino, int distancia){
        matriz[origem][destino] = distancia;
        matriz[destino][origem] = distancia;
    }

    public void exibir() {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }


}
