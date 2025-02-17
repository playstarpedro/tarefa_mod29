package test.main.br.com.psouza;

import br.com.psouza.dao.ClienteDAO;
import br.com.psouza.dao.IGenericDAO;
import br.com.psouza.domain.Cliente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {
    @Test
    public void cadastrarTest() throws Exception {
        IGenericDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Pedro");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = (Cliente) dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(cliente);
        assertNotNull(qtdDel == 1);
    }

    @Test
    public void testConsultar() throws Exception {
        IGenericDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Pedro");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBuscado = (Cliente) dao.consultar(cliente.getCodigo());
        assertEquals(clienteBuscado.getCodigo(), cliente.getCodigo());
        assertEquals(clienteBuscado.getNome(), cliente.getNome());

        Integer qtdDel = dao.excluir(cliente);
        assertNotNull(qtdDel == 1);
    }

    @Test
    public void testExcluir() throws Exception {
        IGenericDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Pedro");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Integer qtdDel = dao.excluir(cliente);
        assertNotNull(qtdDel == 1);
    }

    @Test
    public void testBuscarTodos() throws Exception {
        IGenericDAO dao = new ClienteDAO();
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        cliente1.setCodigo("01");
        cliente1.setNome("Pedro");
        cliente2.setCodigo("02");
        cliente2.setNome("Souza");

        dao.cadastrar(cliente1);
        dao.cadastrar(cliente2);

        List<Cliente> clientes = dao.buscarTodos();
        assertNotNull(clientes);

        assertEquals(clientes.get(0).getCodigo(), cliente1.getCodigo());
        assertEquals(clientes.get(1).getCodigo(), cliente2.getCodigo());

        Integer qtdDel1 = dao.excluir(cliente1);
        Integer qtdDel2 = dao.excluir(cliente2);
        assertNotNull(qtdDel1 == 1);
        assertNotNull(qtdDel2 == 1);
    }

    @Test
    public void testAtualizar() throws Exception {
        IGenericDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Pedro");

        Cliente updatedClient = new Cliente();
        updatedClient.setCodigo("01");
        updatedClient.setNome("Gustavo");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);
        Integer qtdUpdated = dao.atualizar(updatedClient);

        Cliente clienteBuscado = (Cliente) dao.consultar(updatedClient.getCodigo());
        assertNotNull(clienteBuscado);
        assertEquals(clienteBuscado.getCodigo(), updatedClient.getCodigo());
        assertEquals(clienteBuscado.getNome(), updatedClient.getNome());

        Integer qtdDel = dao.excluir(cliente);
        assertNotNull(qtdDel == 1);
    }
}
