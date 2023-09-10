package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;

@SpringBootTest(properties = "spring.config.name=application-test")
public class CadastroServicoTest {

    @Autowired
    private CadastroServico cadastroServico;

    @Test
    public void testCadastrarEListarServico() {
        Servico servico = new Servico("Corte Teste", "Teste classe", BigDecimal.valueOf(50.0));
        Servico servicoSalvo = cadastroServico.salvarServico(servico);
        assertNotNull(servicoSalvo.getId());
        List<Servico> servicos = cadastroServico.listarServicos();
        assertTrue(servicos.contains(servicoSalvo));
    }
}
