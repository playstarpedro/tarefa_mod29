package br.com.psouza.dao;

import br.com.psouza.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements IGenericDAO{
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        return 0;
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        return 0;
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        return List.of();
    }

    @Override
    public Cliente consultar(String codigo) throws SQLException {
        return null;
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        return 0;
    }
}
