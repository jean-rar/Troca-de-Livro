package br.com.novaroma.projeto.utils;

import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.excecoes.ExcecaoUsuario;
import br.com.novaroma.projeto.negocios.UsuarioNegocio;

import java.io.IOException;
import java.util.Scanner;

public class Utils {
    private static UsuarioNegocio un = new UsuarioNegocio();
    private static Scanner input = new Scanner(System.in);

    public static boolean validarData(String string) {

        String padrao = "\\d{2}/\\d{2}/\\d{4}";

        if (string.matches(padrao)) {
            System.out.println("Data de nascimento válida!");
            return true;
        } else {
            System.err.println("Data de nascimento inválida! ");
        }
        return false;
    }

    public static boolean verificarEmail(String email) throws IOException, ClassNotFoundException {
        if (un.existeUsuario(email)) {
            System.out.println("Enail válido! ");
            return true;
        } else {
            System.out.println("Email já existe! ");
        }

        return false;
    }

    public void senhaNaoConfere(Usuario usuario) throws ExcecaoUsuario {
        System.out.println("Senha não confere!");
        String confirma;
        do {
            System.out.print("Confirme a Senha: ");
            confirma = input.nextLine();
        } while (!usuario.getSenha().equals(confirma));
    }
}
