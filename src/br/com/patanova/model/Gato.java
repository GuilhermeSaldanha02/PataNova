package br.com.patanova.model;

public class Gato extends Animal {
    private String temperamento;

    public Gato(String nome, int idade, String temperamento) {
        super(nome, idade);
        this.temperamento = temperamento;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Gato: " + getNome() + ", Temperamento: " + temperamento + ", Status: " + getStatus());
    }
}