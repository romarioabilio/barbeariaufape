package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String telefone, Endereco endereco) {
        super(nome, cpf, telefone, endereco);
    }

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
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
