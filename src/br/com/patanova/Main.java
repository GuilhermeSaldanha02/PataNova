package br.com.patanova;

import br.com.patanova.controller.AdotanteController;
import br.com.patanova.controller.AnimalController;
import br.com.patanova.model.Animal;
import br.com.patanova.model.Cachorro;
import br.com.patanova.model.Gato;

import java.util.Scanner;

public class Main {
    private static AnimalController animalController = new AnimalController();
    private static AdotanteController adotanteController = new AdotanteController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        animalController.cadastrar(new Cachorro("Rex", 3, "Grande"));
        animalController.cadastrar(new Gato("Mimi", 2, "Dócil"));
        adotanteController.cadastrar("Carlos", "123.456.789-00", "Rua A");

        System.out.println("=== Sistema PataNova (Arquitetura em Camadas) ===");

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
                    viewCadastrarAnimal(scanner);
                    break;
                case 2:
                    viewCadastrarAdotante(scanner);
                    break;
                case 3:
                    System.out.print("Nome do animal: ");
                    animalController.disponibilizar(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Nome do Adotante: ");
                    String nomeAdotante = scanner.nextLine();
                    System.out.print("Nome do Animal: ");
                    String nomeAnimal = scanner.nextLine();
                    animalController.adotar(nomeAnimal, nomeAdotante);
                    break;
                case 5:
                    System.out.println("\n--- Animais Disponíveis ---");
                    for (Animal a : animalController.listarDisponiveis()) {
                        a.exibirDetalhes();
                    }
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void viewCadastrarAnimal(Scanner scanner) {
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
            animalController.cadastrar(new Cachorro(nome, idade, porte));
        } else if (tipo == 2) {
            System.out.print("Temperamento: ");
            String temp = scanner.nextLine();
            animalController.cadastrar(new Gato(nome, idade, temp));
        }
    }

    private static void viewCadastrarAdotante(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        adotanteController.cadastrar(nome, cpf, endereco);
    }
}