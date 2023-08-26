package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import java.util.List;

public interface InterfaceCadastroCliente {

	List<Cliente> procurarClienteNome(String nome);

	Cliente procurarClienteId(long id);

	List<Cliente> listarClientes();

	void deletarClienteId(Long id);

	Cliente salvarCliente(Cliente entity);

	void deletarCliente(Cliente cliente);

    Cliente atualizarCliente(Cliente cliente);

}