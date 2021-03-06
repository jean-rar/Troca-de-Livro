package br.com.novaroma.projeto.apresentacao;

import br.com.novaroma.projeto.entidades.*;
import br.com.novaroma.projeto.excecoes.ExcecaoUsuario;
import br.com.novaroma.projeto.negocios.UsuarioNegocio;

import java.io.IOException;
import java.util.*;

public class CadastroLivroInteresse {
    private UsuarioNegocio un = new UsuarioNegocio();
    private static Map<String, Livro> buscador;
    private Usuario usuario = new Usuario();

    public Usuario cadastro(String email) throws ExcecaoUsuario, IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        buscarUsuario(email);

        List<Livro> livros = new ArrayList<>();
        String continuar = "1";
        buscador = new HashMap<>();

        while ("1".equals(continuar)) {
            Livro livro = new Livro();

            System.out.print("Informe o nome do livro: ");
            String nome = input.nextLine();
            System.out.print("Informe o autor: ");
            String autor = input.nextLine();
            System.out.print("Informe a editora: ");
            String editora = input.nextLine();
            System.out.print("Informe o ISBN: ");
            String isbn = input.nextLine();
            System.out.print("Informe o número de páginas: ");
            String nPaginas = input.nextLine();
            System.out.print("Informe o idioma: ");
            String idioma = input.nextLine();
            System.out.print("Informe o número de edição: ");
            String nEdicao = input.nextLine();
            System.out.print("Informe o ano de edição: ");
            String anoEdicao = input.nextLine();

            System.out.print("\n        Informe o tipo do livro\n" +
                    "_________________________________________________\n" +
                    "|1| HQ" + "   |2| Literal" + "   |3| Ficção" + "   |4| Didático\n" + "- ");

            String opcao = input.nextLine();

            if (opcao.equals("1")) {

                System.out.print("Informe o gênero: ");
                String genero = input.nextLine();
                System.out.print("Informe a marca: ");
                String marca = input.nextLine();
                System.out.print("Informe o ilustrador: ");
                String ilustrador = input.nextLine();

                livro = new Hqs(marca, ilustrador, genero, nome, autor, editora, isbn, nPaginas, idioma, nEdicao, anoEdicao);

                buscador.put(isbn, livro);

            } else if (opcao.equals("2")) {

                System.out.print("Informe o gênero: ");
                String genero = input.nextLine();
                System.out.print("Informe o tipo da literatura: ");
                String tipo = input.nextLine();

                livro = new Literatura(tipo, genero, nome, autor, editora, isbn, nPaginas, idioma, nEdicao, anoEdicao);

                buscador.put(isbn, livro);

            } else if (opcao.equals("3")) {

                System.out.print("Informe o gênero: ");
                String genero = input.nextLine();

                livro = new Paradidatico(genero, nome, autor, editora, isbn, nPaginas, idioma, nEdicao, anoEdicao);

                buscador.put(isbn, livro);

            } else if (opcao.equals("4")) {

                System.out.print("Informe a matéria: ");
                String materia = input.nextLine();
                System.out.print("Informe o grau: ");
                String grau = input.nextLine();
                System.out.print("Informe o volume: ");
                String volume = input.nextLine();

                livro = new Didatico(grau, volume, materia, nome, autor, editora, isbn, nPaginas, idioma, nEdicao, anoEdicao);

                buscador.put(isbn, livro);
            }

            usuario.getLivrosInteresse().add(livro);
            System.out.print("Adicionar mais livro? |1|SIM |2|NÃO ");
            continuar = input.nextLine();
        }

        try {
            un.atualizarUsuario(usuario);
        } catch (ExcecaoUsuario e) {
            System.out.println("\n" + e.getMessage());
        }
        System.out.println("Cadastro realizado! \n");

        return usuario;
    }



    public Livro buscarLivroInteresse(String isbn, String email){
        Usuario usuario = new Usuario();
        buscarUsuario(email);
        return buscador.get(isbn);
    }


    public Usuario buscarUsuario(String email) {
        try {
            usuario = un.buscarUsuario(email);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuario;
    }

//    public String removerLivroInteresse(String isbn, String email) throws ExcecaoUsuario, IOException, ClassNotFoundException {
//        buscarUsuario(email);
//        buscador.remove(isbn);
//        return "Livro removido! ";
//    }

}
