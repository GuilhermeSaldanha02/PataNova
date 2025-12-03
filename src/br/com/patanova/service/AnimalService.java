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
            System.out.println("Erro: O animal precisa de um nome.");
            return;
        }
        repository.salvar(animal);
        System.out.println("Service: " + animal.getNome() + " cadastrado com sucesso.");
    }

    public void disponibilizarParaAdocao(String nome) {
        Animal animal = repository.buscarPorNome(nome);
        if (animal == null) {
            System.out.println("Erro: Animal não encontrado.");
            return;
        }
        animal.disponibilizarParaAdocao();
    }

    public void realizarAdocao(String nomeAnimal, Adotante adotante) {
        Animal animal = repository.buscarPorNome(nomeAnimal);

        if (animal == null) {
            System.out.println("Erro: Animal não encontrado no sistema.");
            return;
        }

        if (adotante == null) {
            System.out.println("Erro: Adotante inválido.");
            return;
        }

        animal.finalizarAdocao();
    }

    public List<Animal> listarDisponiveis() {
        return repository.buscarTodos().stream()
                .filter(a -> a.getStatus().equals("DISPONÍVEL"))
                .collect(Collectors.toList());
    }
}