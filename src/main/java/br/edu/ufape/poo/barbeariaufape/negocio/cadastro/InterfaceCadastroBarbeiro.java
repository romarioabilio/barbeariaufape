package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.exception.BarbeiroNaoExisteException;

public interface InterfaceCadastroBarbeiro {
    
    Barbeiro salvarBarbeiro(Barbeiro barbeiro) throws BarbeiroDuplicadoException;

    List<Barbeiro> procurarBarbeiroNome(String nome) throws BarbeiroNaoExisteException;

    Barbeiro procurarBarbeiroId(long id) throws BarbeiroNaoExisteException;

    void deletarBarbeiroId(Long id) throws BarbeiroNaoExisteException;

    void deletarBarbeiroEmail(String email) throws BarbeiroNaoExisteException;

    Barbeiro atualizarBarbeiro(Barbeiro barbeiro) throws BarbeiroNaoExisteException;

    List<Barbeiro> listarBarbeiros(); 

}
