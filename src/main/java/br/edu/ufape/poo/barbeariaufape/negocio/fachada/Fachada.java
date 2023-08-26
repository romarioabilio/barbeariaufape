package br.edu.ufape.poo.barbeariaufape.negocio.fachada;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroProduto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroServico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroProduto;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.InterfaceCadastroServico;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.ServicoNaoExisteException;



@Service
public class Fachada {
    @Autowired
    private InterfaceCadastroProduto cadastroProduto;

    @Autowired
    private InterfaceCadastroServico cadastroServico;
    

    public Servico procurarServicoNome(String nome) throws ServicoNaoExisteException{
        return cadastroServico.procurarServicoNome(nome);
    }

	public Servico salvarServico(Servico entity) throws ServicoDuplicadoException{
        return cadastroServico.salvarServico(entity);
    }
    public Servico atualizarServico(Servico servico) throws ServicoNaoExisteException {
        return cadastroServico.atualizarServico(servico);
    }

	public List<Servico> listarServicos(){
        return cadastroServico.listarServicos();
    }

	public boolean verificarExistenciaServicoId(Long id){
        return cadastroServico.verificarExistenciaServicoId(id);
    }

	public Servico localizarServicoId(Long id){
        return cadastroServico.localizarServicoId(id);
    }

	public void removerServicoNome(String nome) throws ServicoNaoExisteException{
        cadastroServico.removerServicoNome(nome);
    }


    public Produto procurarProdutoNome(String nome) throws ProdutoNaoExisteException{
        return cadastroProduto.procurarProdutoNome(nome);
    }

    public  Produto atualizarProduto(Produto produto) throws ProdutoNaoExisteException{
        return cadastroProduto.atualizarProduto(produto);
    }









}
