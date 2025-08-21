import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        int opcaoPrincipal = -1;

        while (opcaoPrincipal != 0) {
            System.out.println("\n -~* MENU PRINCIPAL *~- ");
            System.out.println("1 - Gerenciar Produtos");
            System.out.println("2 - Gerenciar Categorias");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcaoPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcaoPrincipal) {
                case 1:
                    menuProdutos(sc, produtoDAO);
                    break;
                case 2:
                    menuCategorias(sc, categoriaDAO);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    //Menu Produtos
    private static void menuProdutos(Scanner sc, ProdutoDAO produtoDAO) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n -~* MENU PRODUTOS *~- ");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nomeProd = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();
                    Produto p = new Produto(nomeProd, preco);
                    produtoDAO.inserir(p);
                    break;

                case 2:
                    for (Produto prod : produtoDAO.listar()) {
                        System.out.println(prod);
                    }
                    break;

                case 3:
                    System.out.print("ID do produto a atualizar: ");
                    int idUp = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo preço: ");
                    double novoPreco = sc.nextDouble();
                    sc.nextLine();
                    Produto pAtualizar = new Produto(idUp, novoNome, novoPreco);
                    produtoDAO.atualizar(pAtualizar);
                    break;

                case 4:
                    System.out.print("ID do produto a deletar: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();
                    produtoDAO.deletar(idDel);
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    //Menu Categorias
    private static void menuCategorias(Scanner sc, CategoriaDAO categoriaDAO) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n -~* MENU CATEGORIAS *~- ");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da categoria: ");
                    String nomeCat = sc.nextLine();
                    System.out.print("Ativo (true/false): ");
                    boolean ativo = sc.nextBoolean();
                    sc.nextLine();
                    Categoria c = new Categoria(nomeCat, ativo);
                    categoriaDAO.inserir(c);
                    break;

                case 2:
                    for (Categoria cat : categoriaDAO.listar()) {
                        System.out.println(cat);
                    }
                    break;

                case 3:
                    System.out.print("ID da categoria a atualizar: ");
                    int idCatUp = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNomeCat = sc.nextLine();
                    System.out.print("Ativo (true/false): ");
                    boolean novoAtivo = sc.nextBoolean();
                    sc.nextLine();
                    Categoria cAtualizar = new Categoria(idCatUp, novoNomeCat, novoAtivo);
                    categoriaDAO.atualizar(cAtualizar);
                    break;

                case 4:
                    System.out.print("ID da categoria a deletar: ");
                    int idCatDel = sc.nextInt();
                    sc.nextLine();
                    categoriaDAO.deletar(idCatDel);
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
