package br.com.psouza.dao;

import br.com.psouza.domain.Cliente;
import br.com.psouza.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements IGenericDAO <Produto>{
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        return 0;
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        return 0;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        return List.of();
    }

    @Override
    public Produto consultar(String codigo) throws SQLException {
        return null;
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        return 0;
    }
}
