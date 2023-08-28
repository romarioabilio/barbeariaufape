package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import java.util.List;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ClienteNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ClienteDuplicadoException;

public interface InterfaceCadastroCliente {

	List<Cliente> procurarClienteNome(String nome) throws ClienteNaoExisteException;

	Cliente procurarClienteId(long id) throws ClienteNaoExisteException;

	List<Cliente> listarClientes();

	void deletarClienteId(Long id) throws ClienteNaoExisteException;

	Cliente salvarCliente(Cliente cliente) throws ClienteDuplicadoException;

	void deletarCliente(Cliente cliente) throws ClienteNaoExisteException;

    Cliente atualizarCliente(Cliente cliente) throws ClienteNaoExisteException;

	void deletarClienteEmail(String email) throws ClienteNaoExisteException;

	Cliente procurarClienteEmail(String email) throws ClienteNaoExisteException;

}