package br.com.novaroma.projeto.apresentacao;

import br.com.novaroma.projeto.entidades.Administrador;
import br.com.novaroma.projeto.entidades.Livro;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.excecoes.ExcecaoUsuario;
import br.com.novaroma.projeto.negocios.AdministradorNegocio;
import br.com.novaroma.projeto.negocios.LivroNegocio;
import br.com.novaroma.projeto.negocios.UsuarioNegocio;
import br.com.novaroma.projeto.utils.Utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class Telas {
    static UsuarioNegocio un = new UsuarioNegocio();
    static CadastrarUsuario cdu = new CadastrarUsuario();
    static CadastroLivro cl = new CadastroLivro();
    static LivroNegocio ln = new LivroNegocio();
    static CadastroLivroInteresse cli = new CadastroLivroInteresse();

    private static Scanner input = new Scanner(System.in);
    private static Usuario usuario = new Usuario();
    private static Livro l = new Livro();

    public void telaLogin() throws IOException, ClassNotFoundException, ExcecaoUsuario {
        boolean loop = true;

        do {

            System.out.println("\n       T R O C A   D E   L I V R O S            ");
            System.out.println("__________________________________________________");
            System.out.print("|1|Login  |2|Cadastrar   |3|Adminstrador  |4|Sair\n");
            int opcao = Integer.parseInt(input.nextLine());

            if (opcao == 1) {
                System.out.print("Email: ");
                String email = input.nextLine();
                System.out.print("Senha: ");
                String senha = input.nextLine();

                try {
                    usuario = un.buscarUsuario(email);
                    if (usuario != null && senha.equals(usuario.getSenha())) {
                        telaUsuario();
                    } else {
                        System.out.println("Dados inválidos!");
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (ExcecaoUsuario excecaoUsuario) {
                    excecaoUsuario.printStackTrace();
                }

            } else if (opcao == 2) {
                un.cadastrarUsuario(cdu.cadastar());
                telaLogin();

            } else if (opcao == 3) {
                Administrador adm = new Administrador();
                System.out.print("Email: ");
                String email = input.nextLine();
                System.out.print("Senha: ");
                String senha = input.nextLine();
                if (adm.getEmail().equals(email) && adm.getSenha().equals(senha)) {
                    telaAdm();
                } else {
                    System.out.println("Dados inválidos.");
                }

            } else if (opcao == 4) {
                System.exit(0);
            } else {
                loop = false;
                System.out.print("Digite uma opção válida\n");
            }

        } while (loop);

    }

    public void telaUsuario() throws IOException, ClassNotFoundException, ExcecaoUsuario {
        boolean loop = true;

        Locale locale = new Locale("pt","BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador  = new SimpleDateFormat("dd' de 'MMMMM' de 'YYYY' - 'HH':'mm'h'", locale);

        do {
            System.out.print("\n");
            System.out.print("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n");
//            System.out.println("Usuário: " + usuario.getNome());
            System.out.println(formatador.format(calendar.getTime()));
            System.out.print("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n");
            System.out.print("|1 | Ver Perfil\n");
            System.out.print("|2 | Editar Informações Pessoais\n");
            System.out.print("|3 | Ver Biblioteca\n");
            System.out.print("|4 | Cadastrar Livro\n");
            System.out.print("|5 | Cadastrar livro de interesse\n");
            System.out.print("|6 | Excluir Conta\n");
            System.out.print("|7 | Buscar Livro\n");
            System.out.print("|8 | Remover Livro\n");
            System.out.print("|9 | Listar usuários com livros de meu interesse\n");
            System.out.print("|10| Buscar Livro de Interesse\n");
            System.out.print("|11| Remover Livro de Interesse\n");
            System.out.println("|0 | Sair ");
            System.out.print("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n");
            System.out.print("- ");
            int opcao = Integer.parseInt(input.nextLine());

            if (opcao == 1) {
                System.out.println(usuario.toString());

            } else if (opcao == 2) {

                try {
                    System.out.print("Informe seu nome: ");
                    usuario.setNome(input.nextLine());
                    System.out.print("Informe sua data de nascimento: ");
                    usuario.setNascimento(input.nextLine());

                    while (Utils.validarData(usuario.getNascimento()) != true) {
                        System.err.println("Digite a data no formado: XX/XX/XXXX");
                        usuario.setNascimento(input.nextLine());
                    }

                    System.out.print("Informe uma senha: ");
                    usuario.setSenha(input.nextLine());
                    System.out.print("Confirme a senha: ");
                    String confirma = input.nextLine();

                    un.atualizarUsuario(usuario);

                    System.out.println("\nU s u á r i o   A t u a l i z a d o");
                    System.out.println(usuario);

                } catch (ExcecaoUsuario e) {
                    System.out.println(e.getMessage());
                }

            } else if (opcao == 3) {
                System.out.println(ln.listarLivros(usuario.getEmail()));

            } else if (opcao == 4) {
                System.out.println(cl.cadastro(usuario.getEmail()));

            } else if (opcao == 5) {
                System.out.println(cli.cadastro(usuario.getEmail()));

            } else if (opcao == 6) {
                try {
                    un.removerUsuario(usuario.getEmail());
                } catch (ExcecaoUsuario e) {
                    System.out.println(e.getMessage());
                }
                telaLogin();

            } else if (opcao == 7) {
                System.out.print("informe o isbn: ");
                String isbn = input.nextLine();
                System.out.println(ln.buscarLivro(usuario.getEmail(), isbn));
                telaUsuario();

            } else if (opcao == 8) {
                System.out.print("Informe o isbn: ");
                String isbn = input.nextLine();
                System.out.println(ln.removerLivro(usuario.getEmail(), isbn));
                un.atualizarUsuario(usuario);
                telaUsuario();

            } else if (opcao == 9) {
//                System.out.print("Faça login novamente!! ");
//                telaLogin();

                List<Usuario> usuarios = un.listarTodos();
                Set<Usuario> usuariosInteresse = new HashSet<>();

                for (Livro livro : usuario.getLivrosInteresse()) {
                    for (Usuario usuario : usuarios) {
                        if (!usuario.equals(this.usuario)) {
                            for (Livro l : usuario.getLivros()) {
                                if (livro.getIsbn().equals(l.getIsbn()))
                                    usuariosInteresse.add(usuario);
                            }
                        }
                    }
                }

                System.out.println("Usuários que possuem os livros que você tem interesse: ");
                for (Usuario usuario : usuariosInteresse) {
                    System.out.println(usuario.getNome() + " - " + usuario.getEmail());
                }

                telaUsuario();

            }else if (opcao == 10) {
                System.out.print("informe o isbn: ");
                String isbn = input.nextLine();
                System.out.println(cli.buscarLivroInteresse(isbn, usuario.getEmail()));

             }else if (opcao == 0) {
                loop = false;
                telaLogin();

            }else if(opcao == 11){
                System.out.print("Informe o isbn: ");
                String isbn = input.nextLine();
//                System.out.println(cli.removerLivroInteresse(isbn, usuario.getEmail()));
                System.out.println(ln.removerLivroInteresse(usuario.getEmail(),isbn));
                un.atualizarUsuario(usuario);
            }

        } while (loop);
    }

    public void telaAdm() throws ExcecaoUsuario, IOException, ClassNotFoundException {
        boolean loop = true;

        while (loop){

            System.out.println("____________________");
            System.out.println("|1| Listar Usuários");
            System.out.println("|2| Excluir Usuário");
            System.out.println("|0| Sair");
            System.out.print("____________________\n -");
            int opcao = Integer.parseInt(input.nextLine());

            if(opcao == 1){
                AdministradorNegocio admn = new AdministradorNegocio();
                System.out.println(admn.exibirUsuarios());
                telaAdm();

            }else if(opcao == 2){
                System.out.print("Informe o email do usuário: ");
                String email = input.nextLine();
                un.removerUsuario(email);
                telaAdm();
            }else if(opcao == 0){
                System.out.println("Saindo e salvando aterações...");
                loop = false;
            }
            telaLogin();
        }
    }
}
