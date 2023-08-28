package br.edu.ufape.poo.barbeariaufape.negocio.fachada;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
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
//import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroNaoExisteException;
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


    public Produto procurarProdutoNome(String nome) throws ProdutoNaoExisteException{
        return cadastroProduto.procurarProdutoNome(nome);
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
    public void removerProdutoNome(String nome) throws ProdutoNaoExisteException{
        cadastroProduto.removerProdutoNome(nome);
    }
    public  Produto atualizarProduto(Produto produto) throws ProdutoNaoExisteException{
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








}
