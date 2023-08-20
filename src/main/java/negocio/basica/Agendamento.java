package negocio.basica;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime dataHora;
    
    @ManyToOne
    private Barbeiro barbeiro;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Servico servico;
    
    // Construtores, getters e setters
    
    public Agendamento() {
        // Construtor vazio necessário para JPA
    }

    public Agendamento(LocalDateTime dataHora, Barbeiro barbeiro, Cliente cliente, Servico servico) {
        this.dataHora = dataHora;
        this.barbeiro = barbeiro;
        this.cliente = cliente;
        this.servico = servico;
    }

    // Getters e setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}