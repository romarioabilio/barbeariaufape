package br.edu.ufape.poo.barbeariaufape.negocio.fachada;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Admin;
//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;
//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;
//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Endereco;
//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Pagamento;
//import br.edu.ufape.poo.barbeariaufape.negocio.basica.Pessoa;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
//import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroProduto;
//import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroServico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroServico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroBarbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroCliente;
//import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ClienteDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ClienteNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoNaoExisteException;



@Service
public class Fachada {
    @Autowired
    private InterfaceCadastroProduto cadastroProduto;

    @Autowired
    private InterfaceCadastroServico cadastroServico;
    
    @Autowired
    private InterfaceCadastroBarbeiro cadastroBarbeiro;

    @Autowired
    private InterfaceCadastroCliente cadastroCliente;

    public Servico procurarServicoNome(String nome) throws ServicoNaoExisteException{
        return cadastroServico.procurarServicoNome(nome);
    }

	public Servico salvarServico(Servico entity) throws ServicoDuplicadoException{
        return cadastroServico.salvarServico(entity);
    }
   
	public List<Servico> listarServicos(){
        return cadastroServico.listarServicos();
    }

	public boolean verificarExistenciaServicoId(Long id) throws ServicoNaoExisteException{
        return cadastroServico.verificarExistenciaServicoId(id);
    }

	public Servico localizarServicoId(Long id) throws ServicoNaoExisteException{
        return cadastroServico.localizarServicoId(id);
    }

	public void removerServicoNome(String nome) throws ServicoNaoExisteException{
        cadastroServico.removerServicoNome(nome);
    }
     public Servico atualizarServico(Servico servico) throws ServicoNaoExisteException {
        return cadastroServico.atualizarServico(servico);
    }


    public Produto procurarProduto(Long id) {
        return cadastroProduto.procurarProduto(id);
    }
    public Produto salvarProduto(Produto entity) throws  ProdutoDuplicadoException{
        return cadastroProduto.salvarProduto(entity);
    }
    public List<Produto> listarProdutos(){
        return cadastroProduto.listarProdutos();
    }
    public boolean verificarExistenciaProdutoId(Long id) throws ProdutoNaoExisteException{
        return cadastroProduto.verificarExistenciaProdutoId(id);
    }
    public Produto localizarProdutoId(Long id) throws ProdutoNaoExisteException{
        return cadastroProduto.localizarProdutoId(id);
    }
    public void removerProduto(Long id){
        cadastroProduto.removerProduto(id);
    }
    public  Produto atualizarProduto(Produto produto){
        return cadastroProduto.atualizarProduto(produto);
    }

    public Barbeiro salvarBarbeiro(Barbeiro barbeiro) throws BarbeiroDuplicadoException{
        return cadastroBarbeiro.salvarBarbeiro(barbeiro);
    }

    public List<Barbeiro> procurarBarbeiroNome(String nome) throws BarbeiroNaoExisteException{
        return cadastroBarbeiro.procurarBarbeiroNome(nome);
    }

    public Barbeiro procurarBarbeiroId(long id) throws BarbeiroNaoExisteException{
        return cadastroBarbeiro.procurarBarbeiroId(id);
    }
    
    public void deletarBarbeiroId(Long id) throws BarbeiroNaoExisteException{
        cadastroBarbeiro.deletarBarbeiroId(id);
    }

    public void deletarBarbeiroEmail(String email) throws BarbeiroNaoExisteException{
        cadastroBarbeiro.deletarBarbeiroEmail(email);
    }

    public Barbeiro atualizarBarbeiro(Barbeiro barbeiro) throws BarbeiroNaoExisteException{
        return cadastroBarbeiro.atualizarBarbeiro(barbeiro);
    }

    public List<Barbeiro> listarBarbeiros(){
        return cadastroBarbeiro.listarBarbeiros();
    }

    public List<Cliente> procurarClienteNome(String nome) throws ClienteNaoExisteException{
        return cadastroCliente.procurarClienteNome(nome);
    }

	public Cliente procurarClienteId(long id) throws ClienteNaoExisteException{
        return cadastroCliente.procurarClienteId(id);
    }

	public List<Cliente> listarClientes() {
        return cadastroCliente.listarClientes();
    }

	public void deletarClienteId(Long id) throws ClienteNaoExisteException{
        cadastroCliente.deletarClienteId(id);
    }

	public Cliente salvarCliente(Cliente cliente) throws ClienteDuplicadoException{
        return cadastroCliente.salvarCliente(cliente);
    }

	public void deletarCliente(Cliente cliente) throws ClienteNaoExisteException{
        cadastroCliente.deletarCliente(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente) throws ClienteNaoExisteException{
        return cadastroCliente.atualizarCliente(cliente);
    }

	public void deletarClienteEmail(String email) throws ClienteNaoExisteException {
        cadastroCliente.deletarClienteEmail(email);
    }

	public Cliente procurarClienteEmail(String email) throws ClienteNaoExisteException {
        return cadastroCliente.procurarClienteEmail(email);
    }









}
