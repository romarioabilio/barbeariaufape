package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;


import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Pagamento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;

public interface InterfaceCadastroAtendimento {

    Atendimento cadastrarAtendimento(Barbeiro barbeiro, Servico servico, Produto produto, Pagamento pagamento, Cliente cliente);
    Atendimento atualizarAtendimento(Long id, Barbeiro barbeiro, Servico servico, Produto produto, Pagamento pagamento, Cliente cliente);
    boolean deletarAtendimento(Long id);
    List<Atendimento> listarAtentimento();

}