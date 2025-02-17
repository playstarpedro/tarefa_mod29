package br.com.psouza.dao;

import br.com.psouza.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO <T> {
    public Integer cadastrar(T t) throws Exception;

    public Integer atualizar(T t) throws Exception;

    public List<T> buscarTodos() throws Exception;

    T consultar(String codigo) throws SQLException;

    public Integer excluir(T t) throws Exception;
}
