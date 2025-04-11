import model.Grafo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Grafo grafo = new Grafo(4);

        // Adicionando vértices
        grafo.adicionarVertice(0, "A");
        grafo.adicionarVertice(1, "B");
        grafo.adicionarVertice(2, "C");
        grafo.adicionarVertice(3, "D");

        // Adicionando arestas com distâncias
        grafo.adicionarAresta(0, 1, 5); // A-B com distância 5
        grafo.adicionarAresta(1, 2, 10); // B-C com distância 10
        grafo.adicionarAresta(0, 2, 15); // A-C com distância 15
        grafo.adicionarAresta(2, 3, 5); // C-D com distância 5


        // Exibindo a matriz de adjacência
        grafo.exibirMatrizAdjacente();

        grafo.buscarVizinho(2);
        grafo.listaOrdenadaVizinho(2);

    }
}
