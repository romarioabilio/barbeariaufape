package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;

@SpringBootTest(properties = "spring.config.name=application-test")
public class CadastroProdutoTest {

    @Autowired
    private CadastroProduto cadastroProduto;

    @Test
    public void testCadastrarEListarProduto() {
        Produto produto = new Produto("Pomada Teste", BigDecimal.valueOf(20.0),"Cadastro Teste", BigDecimal.valueOf(10.0));
        Produto produtoSalvo = cadastroProduto.salvarProduto(produto);
        assertNotNull(produtoSalvo.getId());
        List<Produto> produtos = cadastroProduto.listarProdutos();
        assertTrue(produtos.contains(produtoSalvo));

    }
}