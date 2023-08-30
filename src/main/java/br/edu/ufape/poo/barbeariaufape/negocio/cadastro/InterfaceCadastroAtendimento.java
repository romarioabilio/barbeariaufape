package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Cliente;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Servico;

public interface InterfaceCadastroAtendimento {

    Atendimento criarNovoAtendimento(LocalDate data, LocalTime hora, Barbeiro barbeiro, Cliente cliente);
    List<Atendimento> listarAtentimento();
    Atendimento encontrarPorId(Long id);
    Atendimento cadastrarAtendimento(Atendimento atendimento);
    void deletarAtendimento(Long id);
    Atendimento atualizarAtendimento(Long id, Atendimento atendimento);
    void atualizarDados(Atendimento novoAtendimento, Atendimento atendimento);
    void adicionarServico(Atendimento atendimento, Servico servico);
    void adicionarProduto(Atendimento atendimento, Produto produto);
}