package test.main.br.com.psouza;

import br.com.psouza.dao.IGenericDAO;
import br.com.psouza.dao.ProdutoDAO;
import br.com.psouza.domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {
    @Test
    public void cadastrarTest() throws Exception {
        IGenericDAO dao = new ProdutoDAO();
        Produto produto = new Produto("TV Samsung", 2300, "12345");

        Integer qtdCadastrado = dao.cadastrar(produto);
        assertTrue(qtdCadastrado == 1);

        Produto produtoDB = (Produto) dao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        assertEquals(produtoDB.getCodigo(), produto.getCodigo());
        assertEquals(produtoDB.getNome(), produto.getNome());
        assertEquals(produtoDB.getPreco(), produto.getPreco());

        Integer qtdDel = dao.excluir(produto);
        assertNotNull(qtdDel == 1);
    }

    @Test
    public void testConsultar() throws Exception {
        IGenericDAO dao = new ProdutoDAO();
        Produto produto = new Produto("TV Samsung", 2300, "12345");

        dao.cadastrar(produto);

        Produto produtoDB = (Produto) dao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        assertEquals(produtoDB.getCodigo(), produto.getCodigo());
        assertEquals(produtoDB.getNome(), produto.getNome());

        Integer qtdDel = dao.excluir(produto);
        assertNotNull(qtdDel == 1);
    }

    @Test
    public void testExcluir() throws Exception {
        IGenericDAO dao = new ProdutoDAO();
        Produto produto = new Produto("TV Samsung", 2300, "12345");

        Integer qtdCadastrado = dao.cadastrar(produto);
        assertTrue(qtdCadastrado == 1);

        Integer qtdDel = dao.excluir(produto);
        assertNotNull(qtdDel == 1);
    }

    @Test
    public void testBuscarTodos() throws Exception {
        IGenericDAO dao = new ProdutoDAO();
        Produto produto1 = new Produto("TV Samsung", 2300, "12345");
        Produto produto2 = new Produto("IPhone 15", 4500, "54321");

        dao.cadastrar(produto1);
        dao.cadastrar(produto2);

        List<Produto> produtos = dao.buscarTodos();
        assertNotNull(produtos);
        assertEquals(produtos.get(0).getCodigo(), produto1.getCodigo());
        assertEquals(produtos.get(1).getCodigo(), produto2.getCodigo());

        Integer qtdDel1 = dao.excluir(produto1);
        Integer qtdDel2 = dao.excluir(produto2);
        assertNotNull(qtdDel1 == 1);
        assertNotNull(qtdDel2 == 1);
    }

    @Test
    public void testAtualizar() throws Exception {
        IGenericDAO dao = new ProdutoDAO();
        Produto produto = new Produto("TV Samsung", 2300, "12345");
        Produto produtoUpdated = new Produto("TV Samsung 4K", 2800, "12345");

        dao.cadastrar(produto);
        Integer qtdUptaded = dao.atualizar(produtoUpdated);
        assertTrue(qtdUptaded == 1);

        Produto produtoDB = (Produto) dao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        assertEquals(produtoDB.getCodigo(), produtoUpdated.getCodigo());
        assertEquals(produtoDB.getNome(), produtoUpdated.getNome());
        assertEquals(produtoDB.getPreco(), produtoUpdated.getPreco());

        Integer qtdDel = dao.excluir(produto);
        assertNotNull(qtdDel == 1);
    }
}
