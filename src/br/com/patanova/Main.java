package br.com.patanova;

import br.com.patanova.controller.AdotanteController;
import br.com.patanova.controller.AnimalController;
import br.com.patanova.model.Adotante;
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

        while (opcao != 7) {
            limparTela();
            System.out.println("=== Sistema PataNova ===");
            System.out.println("1. Cadastrar Animal");
            System.out.println("2. Cadastrar Adotante");
            System.out.println("3. Disponibilizar Animal");
            System.out.println("4. Realizar Adoção");
            System.out.println("5. Relatório de Animais");
            System.out.println("6. Listar Adotantes");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");

            try {
                String entrada = scanner.nextLine();
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1:
                        viewCadastrarAnimal(scanner);
                        break;
                    case 2:
                        viewCadastrarAdotante(scanner);
                        break;
                    case 3:
                        System.out.print("Nome do animal para disponibilizar: ");
                        String nomeDisp = scanner.nextLine();
                        try {
                            animalController.disponibilizar(nomeDisp);
                            System.out.println("Sucesso: Status alterado!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Nome do Adotante: ");
                        String nomeAdotante = scanner.nextLine();
                        System.out.print("Nome do Animal: ");
                        String nomeAnimal = scanner.nextLine();

                        try {
                            animalController.adotar(nomeAnimal, nomeAdotante);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Falha na Adoção: " + e.getMessage());
                            System.out.println("Dica: Verifique se o animal está DISPONÍVEL e se o Adotante existe.");
                        }
                        break;
                    case 5:
                        System.out.println("\n--- Animais Disponíveis ---");
                        boolean temAnimal = false;
                        for (Animal a : animalController.listarDisponiveis()) {
                            a.exibirDetalhes();
                            temAnimal = true;
                        }
                        if(!temAnimal) System.out.println("Nenhum animal disponível no momento.");
                        break;
                    case 6:
                        System.out.println("\n--- Adotantes Cadastrados ---");
                        for (Adotante a : adotanteController.listar()) {
                            System.out.println("- " + a.getNome());
                        }
                        break;
                    case 7:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite apenas números no menu.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }

            if (opcao != 7) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void viewCadastrarAnimal(Scanner scanner) {
        try {
            System.out.print("Tipo (1-Cachorro, 2-Gato): ");
            int tipo = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            if (tipo == 1) {
                System.out.print("Porte: ");
                String porte = scanner.nextLine();
                animalController.cadastrar(new Cachorro(nome, idade, porte));
            } else {
                System.out.print("Temperamento: ");
                String temp = scanner.nextLine();
                animalController.cadastrar(new Gato(nome, idade, temp));
            }
            System.out.println("Animal cadastrado!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Idade ou Tipo devem ser números.");
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
        System.out.println("Adotante cadastrado!");
    }

    private static void limparTela() {
        for (int i = 0; i < 2; i++) System.out.println();
    }
}