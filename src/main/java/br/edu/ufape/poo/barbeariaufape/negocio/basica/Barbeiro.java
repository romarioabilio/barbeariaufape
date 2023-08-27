package br.edu.ufape.poo.barbeariaufape.negocio.basica;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Barbeiro extends Pessoa {

    private String especialidade;
    

    public Barbeiro() {
        
    }

    public Barbeiro(String nome, String cpf, String telefone, Endereco endereco, String especialidade, double salario) {
        super(nome, cpf, telefone, endereco);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
   
}