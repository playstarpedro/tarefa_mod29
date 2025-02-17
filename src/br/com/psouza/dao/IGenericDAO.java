package br.com.psouza.dao;

import br.com.psouza.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO {
    public Integer cadastrar(Cliente cliente) throws Exception;

    public Integer atualizar(Cliente cliente) throws Exception;

    public List<Cliente> buscarTodos() throws Exception;

    Cliente consultar(String codigo) throws SQLException;

    public Integer excluir(Cliente cliente) throws Exception;
}
