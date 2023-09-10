package br.edu.ufape.poo.barbeariaufape.dados;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import java.util.List;

public interface InterfaceColecaoServicoTest {
    Servico salvarServico(Servico servico);
    List<Servico> listarServicos();
    // Outros métodos relacionados a serviços, se necessário
}
