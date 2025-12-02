package br.com.patanova;

import br.com.patanova.model.Adotante;
import br.com.patanova.model.Animal;
import br.com.patanova.model.Cachorro;
import br.com.patanova.model.Gato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Animal> animais = new ArrayList<>();
    private static List<Adotante> adotantes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        animais.add(new Cachorro("Rex", 3, "Grande"));
        animais.add(new Gato("Mimi", 2, "Dócil"));
        adotantes.add(new Adotante("Carlos", "123.456.789-00", "Rua A"));

        System.out.println("=== Sistema PataNova Iniciado ===");

        while (opcao != 6) {
            System.out.println("\n1. Cadastrar Animal");
            System.out.println("2. Cadastrar Adotante");
            System.out.println("3. Disponibilizar Animal para Adoção");
            System.out.println("4. Realizar Adoção");
            System.out.println("5. Relatório de Animais Disponíveis");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarAnimal(scanner);
                    break;
                case 2:
                    cadastrarAdotante(scanner);
                    break;
                case 3:
                    mudarStatusAnimal(scanner);
                    break;
                case 4:
                    realizarAdocao(scanner);
                    break;
                case 5:
                    listarDisponiveis();
                    break;
                case 6:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarAnimal(Scanner scanner) {
        System.out.print("Tipo (1-Cachorro, 2-Gato): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Porte: ");
            String porte = scanner.nextLine();
            animais.add(new Cachorro(nome, idade, porte));
        } else if (tipo == 2) {
            System.out.print("Temperamento: ");
            String temp = scanner.nextLine();
            animais.add(new Gato(nome, idade, temp));
        }
        System.out.println("Animal cadastrado com sucesso!");
    }

    private static void cadastrarAdotante(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        adotantes.add(new Adotante(nome, cpf, endereco));
        System.out.println("Adotante cadastrado!");
    }

    private static void mudarStatusAnimal(Scanner scanner) {
        System.out.print("Nome do animal para disponibilizar: ");
        String nome = scanner.nextLine();
        for (Animal a : animais) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                a.disponibilizarParaAdocao();
                return;
            }
        }
        System.out.println("Animal não encontrado.");
    }

    private static void realizarAdocao(Scanner scanner) {
        System.out.print("Nome do Adotante: ");
        String nomeAdotante = scanner.nextLine();
        Adotante adotante = null;
        for (Adotante a : adotantes) {
            if (a.getNome().equalsIgnoreCase(nomeAdotante)) {
                adotante = a;
                break;
            }
        }

        if (adotante == null) {
            System.out.println("Adotante não encontrado!");
            return;
        }

        System.out.print("Nome do Animal: ");
        String nomeAnimal = scanner.nextLine();
        for (Animal a : animais) {
            if (a.getNome().equalsIgnoreCase(nomeAnimal)) {
                a.finalizarAdocao();
                return;
            }
        }
        System.out.println("Animal não encontrado.");
    }

    private static void listarDisponiveis() {
        System.out.println("\n--- Animais Disponíveis ---");
        boolean encontrou = false;
        for (Animal a : animais) {
            if (a.getStatus().equals("DISPONÍVEL")) {
                a.exibirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum animal disponível no momento.");
    }
}