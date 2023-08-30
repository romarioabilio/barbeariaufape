package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;
import br.edu.ufape.poo.barbeariaufape.dados.InterfaceColecaoAtendimento;

@Service
public class CadastroAtendimento implements InterfaceCadastroAtendimento {

    @Autowired
    private InterfaceColecaoAtendimento colecaoAtendimento;

    @Autowired
    public CadastroAtendimento(InterfaceColecaoAtendimento colecaoAtendimento) {
        this.colecaoAtendimento = colecaoAtendimento;
    }

    @Override
    public List<Atendimento> listarAtentimento() {
        return colecaoAtendimento.findAll();
    }

    @Override
    public Atendimento encontrarPorId(Long id) {
        return this.colecaoAtendimento.findById(id).orElse(null);
    }

    @Override
    public Atendimento cadastrarAtendimento(Atendimento atendimento) {
        Atendimento novoAtendimento = this.colecaoAtendimento.save(atendimento);
        BigDecimal totalServicos = colecaoAtendimento.getTotalServicos(novoAtendimento.getId());
        BigDecimal totalProdutos = novoAtendimento.getTotal(); // Calcular o total dos produtos aqui
        novoAtendimento.setTotal(totalServicos.add(totalProdutos)); // Somar os totais de serviços e produtos
        return this.colecaoAtendimento.save(novoAtendimento);
    }

    @Override
    public void adicionarProduto(Atendimento atendimento, Produto produto) {
        atendimento.getProdutos().add(produto);
        atendimento.setTotal(atendimento.getTotal().add(produto.getPreco()));
    }

    @Override
    public void adicionarServico(Atendimento atendimento, Servico servico) {
        atendimento.getServicos().add(servico);
        atendimento.setTotal(atendimento.getTotal().add(servico.getPreco()));
    }

    @Override
    public void deletarAtendimento(Long id) {
        this.colecaoAtendimento.deleteById(id);
    }

    public Atendimento atualizarAtendimento(Long id, Atendimento atendimento) {
        Atendimento atendimentoExistente = colecaoAtendimento.findById(id).orElse(null);
        if (atendimentoExistente != null) {
            atualizarDados(atendimento, atendimentoExistente);
            return this.colecaoAtendimento.save(atendimentoExistente);
        }
        return null;
    }
     @Override
    public Atendimento criarNovoAtendimento(LocalDate data, LocalTime hora, Barbeiro barbeiro, Cliente cliente) {
        return new Atendimento(data, hora, barbeiro, cliente);
    }

    @Override
    public void atualizarDados(Atendimento novoAtendimento, Atendimento atendimento) {
        atendimento.setData(novoAtendimento.getData());
        atendimento.setHora(novoAtendimento.getHora());
        atendimento.setCliente(novoAtendimento.getCliente());
        atendimento.setBarbeiro(novoAtendimento.getBarbeiro());
        atendimento.setServicos(novoAtendimento.getServicos());
        atendimento.setProdutos(novoAtendimento.getProdutos());
        atendimento.setPagamento(novoAtendimento.getPagamento());
        atendimento.setTotal(novoAtendimento.getTotal());
    }
}