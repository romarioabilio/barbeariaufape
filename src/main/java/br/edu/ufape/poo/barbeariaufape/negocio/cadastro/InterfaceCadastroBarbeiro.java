package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;

public interface InterfaceCadastroBarbeiro {
    
    void criarBarbeiro(Barbeiro barbeiro, List<String> horariosDisponiveis);

    List<Barbeiro> listarBarbeiros(); 

    void adicionarHorarioDisponivel(String horario);

    void removerHorarioAgendado(String horario);

    Iterable<String> verHorariosDisponiveis();

}
