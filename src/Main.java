import controller.GrafoController;
import model.Grafo;
import view.GrafoView;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(11);
        GrafoView view = new GrafoView();
        GrafoController controller = new GrafoController(grafo, view);

        controller.adicionarVertice(0, "AmaroCavalcante");
        controller.adicionarVertice(1, "JoanaTimoteo");
        controller.adicionarVertice(2, "AnaReinaldo");
        controller.adicionarVertice(3, "JoaoGama");
        controller.adicionarVertice(4, "FranciscoPauloDeOliveira");
        controller.adicionarVertice(5, "PedroFernandes");
        controller.adicionarVertice(6, "HerculanoDeMelo");
        controller.adicionarVertice(7, "PorfiroGabrielDosAnjos");
        controller.adicionarVertice(8, "HiginoRoberto");
        controller.adicionarVertice(9, "AntonioMartins");
        controller.adicionarVertice(10, "JoseVicente");

        controller.adicionarAresta(0, 1, 2.9f);
        controller.adicionarAresta(0, 2, 5.7f);
        controller.adicionarAresta(1, 0, 2.9f);
        controller.adicionarAresta(1, 2, 5.7f);
        controller.adicionarAresta(2, 0, 5.7f);
        controller.adicionarAresta(2, 1, 5.7f);
        controller.adicionarAresta(2, 3, 13.6f);
        controller.adicionarAresta(3, 4, 14.7f);
        controller.adicionarAresta(3, 5, 11.4f);
        controller.adicionarAresta(3, 7, 7.6f);
        controller.adicionarAresta(4, 3, 14.7f);
        controller.adicionarAresta(4, 5, 3.6f);

        controller.exibirMatrizAdjacente();
    }
}
