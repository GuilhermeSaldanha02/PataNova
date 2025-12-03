package br.com.patanova.repository;

import br.com.patanova.model.Adotante;
import java.util.ArrayList;
import java.util.List;

public class AdotanteRepository {
    private static List<Adotante> adotantes = new ArrayList<>();
    public void salvar(Adotante adotante) {
        adotantes.add(adotante);
    }

    public List<Adotante> buscarTodos() {
        return adotantes;
    }

    public Adotante buscarPorNome(String nome) {
        for (Adotante a : adotantes) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }
}