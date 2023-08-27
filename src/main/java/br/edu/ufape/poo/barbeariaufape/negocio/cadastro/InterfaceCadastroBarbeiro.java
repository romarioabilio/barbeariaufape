package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroNaoExisteException;

public interface InterfaceCadastroBarbeiro {
    
    Barbeiro salvarBarbeiro(Barbeiro barbeiro);

    List<Barbeiro> procurarBarbeiroNome(String nome);

    Barbeiro procurarBarbeiroId(long id);

    void deletarBarbeiroId(Long id);

    void deletarBarbeiro(Barbeiro barbeiro);

    void deletarBarbeiroEmail(String email) throws BarbeiroNaoExisteException;

    Barbeiro atualizarBarbeiro(Barbeiro barbeiro);

    List<Barbeiro> listarBarbeiros(); 

}
