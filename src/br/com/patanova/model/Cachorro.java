package br.com.patanova.model;

public class Cachorro extends Animal {
    private String porte;

    public Cachorro(String nome, int idade, String porte) {
        super(nome, idade);
        this.porte = porte;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Cachorro: " + getNome() + ", Porte: " + porte + ", Status: " + getStatus());
    }
}