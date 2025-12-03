package br.com.patanova.repository;

import br.com.patanova.model.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {
    private static List<Animal> animais = new ArrayList<>();
    public void salvar(Animal animal) {
        animais.add(animal);
    }

    public List<Animal> buscarTodos() {
        return animais;
    }

    public Animal buscarPorNome(String nome) {
        for (Animal a : animais) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }
}