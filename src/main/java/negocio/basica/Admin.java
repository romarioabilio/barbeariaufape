package negocio.basica;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Pessoa {

    private String cargo;

    public Admin() {
        // Construtor vazio necessário para JPA
    }

    public Admin(String nome, String cpf, String telefone, Endereco endereco, String cargo) {
        super(nome, cpf, telefone, endereco);
        this.cargo = cargo;
    }

    // Getters e setters
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
