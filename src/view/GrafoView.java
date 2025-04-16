package view;

public class GrafoView {

    public void mostrarMatrizAdjacente(float[][] matrix, int size) {
        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
