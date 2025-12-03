package br.com.patanova.controller;

import br.com.patanova.model.Adotante;
import br.com.patanova.service.AdotanteService;
import java.util.List;

public class AdotanteController {
    private AdotanteService service = new AdotanteService();

    public void cadastrar(String nome, String cpf, String endereco) {
        service.cadastrarAdotante(nome, cpf, endereco);
    }

    public List<Adotante> listar() {
        return service.listarTodos();
    }
}