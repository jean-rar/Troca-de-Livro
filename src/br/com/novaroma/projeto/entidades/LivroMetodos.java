package br.com.novaroma.projeto.entidades;

import br.com.novaroma.projeto.excecoes.ExcecaoUsuario;

import java.io.IOException;

public interface LivroMetodos {

    public Livro buscarLivro(String email, String isbn) throws IOException, ClassNotFoundException;

    public String removerLivro(String email, String isbn) throws IOException, ClassNotFoundException, ExcecaoUsuario;

    public String listarLivros(String email) throws IOException, ClassNotFoundException;
}
