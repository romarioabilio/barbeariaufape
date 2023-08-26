package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoCliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;


@Service
public class CadastroCliente implements InterfaceCadastroCliente {
	@Autowired
	private InterfaceColecaoCliente colecaoCliente;

	@Override
	public List<Cliente> procurarClienteNome(String nome) {
		return colecaoCliente.findByNomeContaining(nome);
	}
	
	@Override
	public Cliente procurarClienteId(long id) {
		return colecaoCliente.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> listarClientes() {
		return colecaoCliente.findAll();
	}

	@Override
	public void deletarClienteId(Long id) {
		colecaoCliente.deleteById(id);
	}

	@Override
	public Cliente salvarCliente(Cliente entity) {
		return colecaoCliente.save(entity);
	}
	
	@Override
	public void deletarCliente(Cliente cliente) {
		colecaoCliente.delete(cliente);
	}
    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return colecaoCliente.save(cliente);
    }
}