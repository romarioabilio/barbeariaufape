package br.edu.ufape.poo.barbeariaufape.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroServico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroBarbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroCliente;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ClienteNaoExisteException;

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

    //SERVIÇOS

	public Servico salvarServico(Servico entity) {
        return cadastroServico.salvarServico(entity);
    }
   
	public List<Servico> listarServicos(){
        return cadastroServico.listarServicos();
    }

	public boolean verificarExistenciaServicoId(Long id) {
        return cadastroServico.verificarExistenciaServicoId(id);
    }

	public Servico localizarServicoId(Long id){
        return cadastroServico.localizarServicoId(id);
    }

	
     public Servico atualizarServico(Servico servico) {
        return cadastroServico.atualizarServico(servico);
    }

    public Servico procurarServico(Long id) {
        return cadastroServico.procurarServico(id);
    }

    public void removerServico(Long id) {
        cadastroServico.removerServico(id);
    }


    //PRODUTOS

    public Produto procurarProduto(Long id) {
        return cadastroProduto.procurarProduto(id);
    }
    public Produto salvarProduto(Produto entity) {
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



    //BARBEIROS

    public Barbeiro salvarBarbeiro(Barbeiro barbeiro) {
        return cadastroBarbeiro.salvarBarbeiro(barbeiro);
    }

    public List<Barbeiro> procurarBarbeiroNome(String nome) throws BarbeiroNaoExisteException{
        return cadastroBarbeiro.procurarBarbeiroNome(nome);
    }

    public Barbeiro procurarBarbeiroId(long id) {
        return cadastroBarbeiro.procurarBarbeiroId(id);
    }
    
    public void deletarBarbeiroId(Long id) {
        cadastroBarbeiro.deletarBarbeiroId(id);
    }

    public void deletarBarbeiroEmail(String email) throws BarbeiroNaoExisteException{
        cadastroBarbeiro.deletarBarbeiroEmail(email);
    }

    public Barbeiro atualizarBarbeiro(Barbeiro barbeiro) {
        return cadastroBarbeiro.atualizarBarbeiro(barbeiro);
    }

    public List<Barbeiro> listarBarbeiros(){
        return cadastroBarbeiro.listarBarbeiros();
    }

    //CLIENTES

    public List<Cliente> procurarClienteNome(String nome) {
        return cadastroCliente.procurarClienteNome(nome);
    }

	public Cliente procurarClienteId(long id) {
        return cadastroCliente.procurarClienteId(id);
    }

	public List<Cliente> listarClientes() {
        return cadastroCliente.listarClientes();
    }

	public void deletarClienteId(Long id) {
        cadastroCliente.deletarClienteId(id);
    }

	public Cliente salvarCliente(Cliente cliente) {
        return cadastroCliente.salvarCliente(cliente);
    }

	public void deletarCliente(Cliente cliente) {
        cadastroCliente.deletarCliente(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return cadastroCliente.atualizarCliente(cliente);
    }

	public void deletarClienteEmail(String email) throws ClienteNaoExisteException {
        cadastroCliente.deletarClienteEmail(email);
    }

	public Cliente procurarClienteEmail(String email) throws ClienteNaoExisteException {
        return cadastroCliente.procurarClienteEmail(email);
    }



    //AGENDAMENTOS






    //ATENDIMENTOS
}
