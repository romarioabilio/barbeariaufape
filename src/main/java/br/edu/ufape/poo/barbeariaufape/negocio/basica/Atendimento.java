package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Barbeiro barbeiro;
    
    @ManyToOne
    private Servico servico;
    
    @ManyToOne
    private Produto produto;
    
    @ManyToOne
    private Pagamento pagamento;
    
    public Atendimento() {
        // Construtor vazio necessário para JPA
    }

    public Atendimento(Barbeiro barbeiro, Servico servico, Produto produto, Pagamento pagamento) {
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.produto = produto;
        this.pagamento = pagamento;
    }

    // Getters e setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}