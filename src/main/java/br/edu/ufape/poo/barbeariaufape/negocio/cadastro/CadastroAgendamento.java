package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Agendamento;
import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoAgendamento;

@Service
public class CadastroAgendamento implements InterfaceCadastroAgendamento {

    private final InterfaceColecaoAgendamento interfaceColecaoAgendamento;

    @Autowired
    public cadastroAgendamento(InterfaceColecaoAgendamento interfaceColecaoAgendamento) {
        this.interfaceColecaoAgendamento = interfaceColecaoAgendamento;
    }

    @Override
    public Agendamento salvarAgendamento(Agendamento agendamento) {
        return interfaceColecaoAgendamento.save(agendamento);
    }

    @Override
    public Agendamento consultarAgendamento(Long id) {
        return interfaceColecaoAgendamento.findById(id).orElse(null);
    }

    @Override
    public void excluirAgendamento(Long id) {
        interfaceColecaoAgendamento.deleteById(id);
    }
    
    
}

