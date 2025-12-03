package br.com.patanova.controller;

import br.com.patanova.model.Adotante;
import br.com.patanova.model.Animal;
import br.com.patanova.service.AdotanteService;
import br.com.patanova.service.AnimalService;

import java.util.List;

public class AnimalController {
    private AnimalService animalService = new AnimalService();
    private AdotanteService adotanteService = new AdotanteService();

    public void cadastrar(Animal animal) {
        animalService.cadastrarAnimal(animal);
    }

    public void disponibilizar(String nomeAnimal) {
        animalService.disponibilizarParaAdocao(nomeAnimal);
    }

    public void adotar(String nomeAnimal, String nomeAdotante) {
        Adotante adotante = adotanteService.buscarPorNome(nomeAdotante);
        animalService.realizarAdocao(nomeAnimal, adotante);
    }

    public List<Animal> listarDisponiveis() {
        return animalService.listarDisponiveis();
    }
}