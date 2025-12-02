package br.com.patanova.model;

public abstract class Animal {
    private String nome;
    private int idade;
    private String status;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.status = "RESGATADO";
    }

    public void disponibilizarParaAdocao() {
        if (this.status.equals("RESGATADO")) {
            this.status = "DISPONÍVEL";
            System.out.println(this.nome + " agora está disponível para adoção!");
        } else {
            System.out.println("Não é possível disponibilizar. Status atual: " + this.status);
        }
    }

    public void finalizarAdocao() {
        if (this.status.equals("DISPONÍVEL")) {
            this.status = "ADOTADO";
            System.out.println("Parabéns! " + this.nome + " foi adotado.");
        } else {
            System.out.println("Erro: O animal precisa estar DISPONÍVEL para ser adotado.");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getStatus() {
        return status;
    }

    public abstract void exibirDetalhes();
}