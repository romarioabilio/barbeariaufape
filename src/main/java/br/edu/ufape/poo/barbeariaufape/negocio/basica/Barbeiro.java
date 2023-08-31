package br.edu.ufape.poo.barbeariaufape.negocio.basica;



import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Barbeiro extends Pessoa {

    private String especialidade;

    private double salario;
    

    public Barbeiro() {
        
    }

    public Barbeiro(String nome, String cpf, String telefone, Endereco endereco, String especialidade, double salario) {
        super(nome, cpf, telefone, endereco);
        this.salario = salario;
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @OneToMany(mappedBy = "barbeiro", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Agendamento> agendamentos = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(getId(), other.getId()); // Use getId() instead of id
    }
   
}