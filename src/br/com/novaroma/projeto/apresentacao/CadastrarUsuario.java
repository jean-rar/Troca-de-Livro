package br.com.novaroma.projeto.apresentacao;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.negocios.UsuarioNegocio;
import br.com.novaroma.projeto.utils.Utils;

import java.util.Scanner;

public class CadastrarUsuario extends Usuario {

    public static Scanner input = new Scanner(System.in);
    Utils u = new Utils();
    private UsuarioNegocio un = new UsuarioNegocio();

    public Usuario cadastar() {
        Usuario usuario = new Usuario();

        System.out.print("Informe seu nome: ");
        usuario.setNome(input.nextLine());
        System.out.print("Informe sua data de nascimento: ");
        usuario.setNascimento(input.nextLine());

        while (Utils.validarData(usuario.getNascimento()) != true) {
            System.err.println("Digite a data no formado: XX/XX/XXXX");
            usuario.setNascimento(input.nextLine());
        }

        System.out.print("Informe seu email: ");
        usuario.setEmail(input.nextLine());

        System.out.print("Informe uma senha: ");
        usuario.setSenha(input.nextLine());
        System.out.print("Confirme a senha: ");
        String confirma = input.nextLine();

        System.out.println("\nU s u á r i o   C a d a s t r a d o");
        System.out.println(usuario);

        return usuario;
    }
}
