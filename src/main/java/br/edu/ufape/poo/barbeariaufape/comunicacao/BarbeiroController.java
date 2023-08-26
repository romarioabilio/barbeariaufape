package br.edu.ufape.poo.barbeariaufape.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.poo.barbeariaufape.negocio.basica.Barbeiro;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroBarbeiro;

@RestController
public class BarbeiroController {

    @Autowired
    private CadastroBarbeiro barbeiroService;


    @PostMapping("/criar")
    public String criarBarbeiro(@RequestBody Barbeiro barbeiro) {
        barbeiroService.criarBarbeiro(barbeiro, barbeiro.getHorariosDisponiveis());
        return "Barbeiro criado com sucesso!";
    }

    @GetMapping("/listar")
    public Iterable<Barbeiro> listarBarbeiros() {
        return barbeiroService.listarBarbeiros();
    }

    @PostMapping("/horario")
    public String adicionarHorarioDisponivel(@RequestBody String horario) {
        barbeiroService.adicionarHorarioDisponivel(horario);
        return "Horário disponível adicionado com sucesso!";
    }

    @DeleteMapping("/horario")
    public String removerHorarioAgendado(@RequestBody String horario) {
        barbeiroService.removerHorarioAgendado(horario);
        return "Horário agendado removido com sucesso!";
    }

    @GetMapping("/horarios")
    public Iterable<String> verHorariosDisponiveis() {
        return barbeiroService.verHorariosDisponiveis();
    }
}