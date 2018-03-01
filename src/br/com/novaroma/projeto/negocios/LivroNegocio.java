package br.com.novaroma.projeto.negocios;

import br.com.novaroma.projeto.dados.DadosUsuario;
import br.com.novaroma.projeto.entidades.Livro;
import br.com.novaroma.projeto.entidades.LivroMetodos;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.excecoes.ExcecaoUsuario;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class LivroNegocio implements Serializable, LivroMetodos {

    UsuarioNegocio un = new UsuarioNegocio();
    private Usuario usuario = new Usuario();

    public String listarLivros(String email) throws IOException, ClassNotFoundException {
        buscarUsuario(email);
        return usuario.listarLivros();
    }

    public String removerLivro(String email, String isbn) throws ExcecaoUsuario, IOException, ClassNotFoundException {
        buscarUsuario(email);
        return usuario.removerLivro(isbn);
    }

    public Livro buscarLivro(String email, String isbn) {
        buscarUsuario(email);
        return usuario.buscarLivro(isbn);
    }

    public String removerLivroInteresse(String email, String isbn) throws ExcecaoUsuario, IOException, ClassNotFoundException {
        buscarUsuario(email);
        return usuario.removerLivroInterese(isbn);
    }

    public Usuario buscarUsuario(String email) {
        try {
            usuario = un.buscarUsuario(email);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuario;
    }


}
