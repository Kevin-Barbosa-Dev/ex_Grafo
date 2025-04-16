package model;

public class Vizinho {
    private String nome;
    private float distancia;

    public Vizinho(String nome, float distancia) {
        this.nome = nome;
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public float getDistancia() {
        return distancia;
    }
}
