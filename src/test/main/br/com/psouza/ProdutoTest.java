package test.main.br.com.psouza;

import br.com.psouza.dao.IGenericDAO;
import br.com.psouza.dao.ProdutoDAO;
import br.com.psouza.domain.Produto;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProdutoTest {
    @Test
    public void cadastrarTest() throws Exception {
        IGenericDAO dao = new ProdutoDAO();
        Produto produto = new Produto("TV Samsung", 2300, "12345");

        Integer qtdCadastrado = dao.cadastrar(produto);
        assertTrue(qtdCadastrado == 1);


    }

    @Test
    public void testConsultar() throws Exception {
    }

    @Test
    public void testExcluir() throws Exception {
    }

    @Test
    public void testBuscarTodos() throws Exception {
    }

    @Test
    public void testAtualizar() throws Exception {
    }
}
