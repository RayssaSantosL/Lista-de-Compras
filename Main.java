import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// O objetivo é criar uma lista de compras CRUD (Create, Read, Update, Delete)

class Produto {
  private String nome;
  
  public Produto(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}

public class Main {
  private List<Produto> produtos;
  private Scanner scanner;

  public Main() {
    produtos = new ArrayList<>();
    scanner = new Scanner(System.in);
  }

  public void mostrarMenu() {
    System.out.println("----- MENU -----");
    System.out.println("1. Adicionar produto");
    System.out.println("2. Mostrar lista de compras");
    System.out.println("3. Atualizar produto");
    System.out.println("4. Remover produto");
    System.out.println("5. Sair");
    System.out.print("Digite uma opção: ");
  }

  public void adicionarProduto() {
    System.out.print("Digite o nome do produto: ");
    String nome = scanner.nextLine();

    Produto produto = new Produto(nome);
    produtos.add(produto);
    System.out.println("Produto adicionado com sucesso.");
  }

  public void mostrarLista() {
    if (produtos.isEmpty()) {
      System.out.println("A lista de compras está vazia.");
    } else {
      System.out.println("Lista de compras:");
      for (int i = 0; i < produtos.size(); i++) {
        Produto produto = produtos.get(i);
        System.out.println((i + 1) + ". " + produto.getNome());
      }
    }
  }

  public void atualizarProduto() {
    if (produtos.isEmpty()) {
      System.out.println("A lista de compras está vazia.");
      return;
    }
    mostrarLista();
    System.out.print("Digite o número do produto que deseja atualizar: ");
    int indice = scanner.nextInt();
    scanner.nextLine();

    if (indice >= 1 && indice <= produtos.size()) {
      Produto produto = produtos.get(indice - 1);

      System.out.print("Digite o novo produto: ");
      String nome = scanner.nextLine();
      produto.setNome(nome);
      System.out.println("Produto atualizado com sucesso.");
    } else {
      System.out.println("Índice inválido.");
    }
  }

  public void removerProduto() {
    if (produtos.isEmpty()) {
      System.out.println("A lista de compras está vazia.");
      return;
    }
    mostrarLista();

    System.out.print("Digite o número do produto que deseja remover: ");
    int indice = scanner.nextInt();
    scanner.nextLine();

    if (indice >= 1 && indice <= produtos.size()) {
      produtos.remove(indice - 1);
      System.out.println("Produto removido da lista de compras.");
    } else {
      System.out.println("Índice inválido.");
    }
  }

  public static void main(String[] args) {
    Main listaCompras = new Main();
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      listaCompras.mostrarMenu();
      opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          listaCompras.adicionarProduto();
          break;
        case 2:
          listaCompras.mostrarLista();
          break;
        case 3: 
          listaCompras.atualizarProduto();
          break;
        case 4:
          listaCompras.removerProduto();
          break;
        case 5:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção Inválida.");
      }

      System.out.println();
    } while(opcao != 5);
    scanner.close();
  }
}
