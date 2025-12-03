package br.com.patanova.service;

import br.com.patanova.model.Adotante;
import br.com.patanova.repository.AdotanteRepository;
import java.util.List;

public class AdotanteService {
    private AdotanteRepository repository = new AdotanteRepository();

    public void cadastrarAdotante(String nome, String cpf, String endereco) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do adotante é obrigatório!");
        }

        Adotante novoAdotante = new Adotante(nome, cpf, endereco);
        repository.salvar(novoAdotante);
        System.out.println("Service: Adotante " + nome + " cadastrado com sucesso.");
    }

    public List<Adotante> listarTodos() {
        return repository.buscarTodos();
    }

    public Adotante buscarPorNome(String nome) {
        return repository.buscarPorNome(nome);
    }
}