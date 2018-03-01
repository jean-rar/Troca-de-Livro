package br.com.novaroma.projeto.dados;

import java.io.IOException;
import java.util.ArrayList;

public interface LerArquivo<T> {

    public ArrayList<T> lerArquivo() throws IOException, ClassNotFoundException;
}
