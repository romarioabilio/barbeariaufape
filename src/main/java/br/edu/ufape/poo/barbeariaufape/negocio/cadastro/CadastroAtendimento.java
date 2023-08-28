package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Pagamento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoAtendimento;
import java.util.List;

@Service
public class CadastroAtendimento implements InterfaceCadastroAtendimento{

    @Autowired 
    private InterfaceColecaoAtendimento colecaoAtendimento;

    public Atendimento cadastrarAtendimento(Barbeiro barbeiro, Servico servico, Produto produto, Pagamento pagamento, Cliente cliente) {
        Atendimento novoAtendimento = new Atendimento(barbeiro, servico, produto, pagamento, cliente);
        return colecaoAtendimento.save(novoAtendimento);
    }

    public Atendimento atualizarAtendimento(Long id, Barbeiro barbeiro, Servico servico, Produto produto, Pagamento pagamento, Cliente cliente) {
        Atendimento atendimentoExistente = colecaoAtendimento.findById(id).orElse(null);

        if (atendimentoExistente != null) {
            atendimentoExistente.setBarbeiro(barbeiro);
            atendimentoExistente.setServico(servico);
            atendimentoExistente.setProduto(produto);
            atendimentoExistente.setPagamento(pagamento);
            atendimentoExistente.setCliente(cliente);
            return colecaoAtendimento.save(atendimentoExistente);
        }

        return null; 
    }

    public boolean deletarAtendimento(Long id) {
        Atendimento atendimentoExistente = colecaoAtendimento.findById(id).orElse(null);

        if (atendimentoExistente != null) {
            colecaoAtendimento.delete(atendimentoExistente);
            return true; 
        }

        return false; 
    }
    
    @Override
    public List<Atendimento> listarAtentimento() {
        return colecaoAtendimento.findAll();
    }

   //cadastroatendimento 
}
