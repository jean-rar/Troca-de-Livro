package br.com.novaroma.projeto.apresentacao;

import br.com.novaroma.projeto.excecoes.ExcecaoUsuario;

import java.io.IOException;

public class Principal {
    public static void main (String []args) throws IOException, ClassNotFoundException, ExcecaoUsuario {
        Telas tu = new Telas();
        tu.telaLogin();
    }
}