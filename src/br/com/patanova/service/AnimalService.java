package br.com.patanova.service;

import br.com.patanova.model.Adotante;
import br.com.patanova.model.Animal;
import br.com.patanova.repository.AnimalRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalService {
    private AnimalRepository repository = new AnimalRepository();

    public void cadastrarAnimal(Animal animal) {
        if (animal.getNome().isEmpty()) {
            throw new IllegalArgumentException("O animal precisa de um nome.");
        }
        repository.salvar(animal);
        System.out.println("Service: " + animal.getNome() + " cadastrado com sucesso.");
    }

    public void disponibilizarParaAdocao(String nome) {
        Animal animal = repository.buscarPorNome(nome);
        if (animal == null) {
            throw new IllegalArgumentException("Animal '" + nome + "' não encontrado no sistema.");
        }

        if (!animal.getStatus().equals("RESGATADO")) {
            throw new IllegalArgumentException("O animal não pode ser disponibilizado. Status atual: " + animal.getStatus());
        }
        animal.disponibilizarParaAdocao();
    }

    public void realizarAdocao(String nomeAnimal, Adotante adotante) {
        Animal animal = repository.buscarPorNome(nomeAnimal);

        if (animal == null) {
            throw new IllegalArgumentException("Animal '" + nomeAnimal + "' não encontrado.");
        }

        if (adotante == null) {
            throw new IllegalArgumentException("Adotante não encontrado. Verifique o nome digitado.");
        }

        if (!animal.getStatus().equals("DISPONÍVEL")) {
            throw new IllegalArgumentException("Este animal não está disponível para adoção (Status: " + animal.getStatus() + ").");
        }

        animal.finalizarAdocao();
    }

    public List<Animal> listarDisponiveis() {
        return repository.buscarTodos().stream()
                .filter(a -> a.getStatus().equals("DISPONÍVEL"))
                .collect(Collectors.toList());
    }
}