import model.Grafo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(3);

        grafo.adicionar(0,1,0);
        grafo.adicionar();
    }
}