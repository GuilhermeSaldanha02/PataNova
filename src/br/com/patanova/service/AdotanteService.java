package br.com.patanova.service;

import br.com.patanova.model.Adotante;
import br.com.patanova.repository.AdotanteRepository;

public class AdotanteService {
    private AdotanteRepository repository = new AdotanteRepository();

    public void cadastrarAdotante(String nome, String cpf, String endereco) {
        if (nome == null || nome.isEmpty()) {
            System.out.println("Erro: Nome do adotante é obrigatório!");
            return;
        }

        Adotante novoAdotante = new Adotante(nome, cpf, endereco);
        repository.salvar(novoAdotante);
        System.out.println("Service: Adotante " + nome + " cadastrado com sucesso.");
    }

    public Adotante buscarPorNome(String nome) {
        return repository.buscarPorNome(nome);
    }
}