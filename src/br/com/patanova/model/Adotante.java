package br.com.patanova.model;

public class Adotante {
    private String nome;
    private String cpf;
    private String endereco;

    public Adotante(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Adotante: " + nome + " (CPF: " + cpf + ")";
    }
}