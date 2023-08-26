package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;

@Service
public class CadastroBarbeiro implements InterfaceCadastroBarbeiro {

    private List<Barbeiro> barbeiros = new ArrayList<>();
    private List<String> horariosDisponiveis = new ArrayList<>();

    @Override
    public void criarBarbeiro(Barbeiro barbeiro, List<String> horariosDisponiveis) {
        barbeiros.add(barbeiro);
        this.horariosDisponiveis.addAll(horariosDisponiveis);
    }

    @Override
    public List<Barbeiro> listarBarbeiros() {
        return barbeiros;
    }

    @Override
    public void adicionarHorarioDisponivel(String horario) {
        horariosDisponiveis.add(horario);
    }

    @Override
    public void removerHorarioAgendado(String horario) {
        horariosDisponiveis.remove(horario);
    }

    @Override
    public Iterable<String> verHorariosDisponiveis() {
        for (String horario : horariosDisponiveis) {
            System.out.println(horario);
        }
        return horariosDisponiveis;
    }
}