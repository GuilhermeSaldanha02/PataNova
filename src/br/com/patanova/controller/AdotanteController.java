package br.com.patanova.controller;

import br.com.patanova.service.AdotanteService;

public class AdotanteController {
    private AdotanteService service = new AdotanteService();

    public void cadastrar(String nome, String cpf, String endereco) {
        service.cadastrarAdotante(nome, cpf, endereco);
    }
}