# 🐾 PataNova

> Sistema de Gestão de Adoções para ONGs de Animais

O **PataNova** é um sistema desenvolvido em **Java Puro** para auxiliar pequenas ONGs no controlo de animais resgatados e no fluxo de adoções. O projeto foi estruturado seguindo os pilares da Orientação a Objetos e uma arquitetura em camadas profissional (simulando uma API REST), sem o uso de frameworks externos.

## 📋 Sobre o Projeto

O objetivo principal é resolver a desorganização na gestão de animais e adotantes, substituindo controlos manuais por um sistema centralizado que garante a integridade dos dados e agiliza o processo de adoção.

### Funcionalidades Principais
* **Cadastro de Animais:** Registo de Cães e Gatos com atributos específicos (Herança e Polimorfismo).
* **Gestão de Status:** Controle rigoroso do ciclo de vida do animal (`RESGATADO` -> `DISPONÍVEL` -> `ADOTADO`) via Encapsulamento.
* **Cadastro de Adotantes:** Registo de interessados na adoção.
* **Processo de Adoção:** Associação entre um Adotante e um Animal, com validação de regras de negócio (apenas animais disponíveis podem ser adotados).
* **Relatórios:** Listagem filtrada de animais disponíveis para adoção.

## 🚀 Tecnologias Utilizadas

* **Java (JDK 17+)**: Linguagem principal.
* **Git/GitHub**: Versionamento de código.
* **IntelliJ IDEA**: IDE de desenvolvimento.

## Architecture (Arquitetura do Sistema)

Este projeto foi refatorado para seguir uma **Arquitetura em Camadas (Layered Architecture)**, separando claramente as responsabilidades, similar a uma API REST moderna:

1.  **Model (`br.com.patanova.model`)**:
    * Contém as entidades do domínio: `Animal` (Abstrata), `Cachorro`, `Gato` e `Adotante`.
    * Implementa regras de OO como Herança e Encapsulamento.

2.  **Repository (`br.com.patanova.repository`)**:
    * Responsável pela persistência dos dados.
    * Simula um banco de dados em memória utilizando `List<>`.

3.  **Service (`br.com.patanova.service`)**:
    * Contém toda a **Regra de Negócio**.
    * Realiza validações (ex: verificar se o animal existe, se o adotante é válido, regras de transição de status).

4.  **Controller (`br.com.patanova.controller`)**:
    * Atua como ponto de entrada das requisições.
    * Recebe os comandos da View e delega para os Services apropriados.

5.  **View (`Main.java`)**:
    * Interface de usuário via Console.
    * Responsável apenas por capturar a entrada de dados e exibir as respostas, sem conter lógica de negócio.

## 📂 Estrutura de Pastas

```text
src/
└── br/
    └── com/
        └── patanova/
            ├── Main.java              # Ponto de entrada (Menu)
            ├── controller/            # Camada de Controle
            │   ├── AdotanteController.java
            │   └── AnimalController.java
            ├── model/                 # Entidades e Objetos de Valor
            │   ├── Adotante.java
            │   ├── Animal.java
            │   ├── Cachorro.java
            │   └── Gato.java
            ├── repository/            # Camada de Acesso a Dados (Simulada)
            │   ├── AdotanteRepository.java
            │   └── AnimalRepository.java
            └── service/               # Camada de Serviços (Regras de Negócio)
                ├── AdotanteService.java
                └── AnimalService.java