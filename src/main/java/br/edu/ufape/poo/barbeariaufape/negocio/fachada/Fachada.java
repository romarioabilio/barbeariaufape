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
    

    








}
