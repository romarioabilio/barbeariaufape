package br.edu.ufape.poo.barbeariaufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.poo.barbeariaufape.negocio.basica.Atendimento;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.CadastroAtendimento;

@RestController
@RequestMapping
public class AtendimentoController {

    @Autowired
    private CadastroAtendimento atendimentoService;

    @PostMapping("/criarAtendimento")
    public ResponseEntity<Atendimento> cadastrarAtendimento(@RequestBody Atendimento atendimento) {
        Atendimento novoAtendimento = atendimentoService.cadastrarAtendimento(
                atendimento.getBarbeiro(),
                atendimento.getServico(),
                atendimento.getProduto(),
                atendimento.getPagamento(),
                atendimento.getCliente()
        );
        return new ResponseEntity<>(novoAtendimento, HttpStatus.CREATED);
    }

    @PutMapping("/atualizarAtendimento/{id}")
    public ResponseEntity<Atendimento> atualizarAtendimento(
            @PathVariable Long id,
            @RequestBody Atendimento atendimento) {Atendimento atendimentoAtualizado = atendimentoService.atualizarAtendimento(
                id,
                atendimento.getBarbeiro(),
                atendimento.getServico(),
                atendimento.getProduto(),
                atendimento.getPagamento(),
                atendimento.getCliente()
        );

        if (atendimentoAtualizado != null) {
            return new ResponseEntity<>(atendimentoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletarAtendimentoId/{id}")
    public ResponseEntity<Void> deletarAtendimento(@PathVariable Long id) {
        boolean sucesso = atendimentoService.deletarAtendimento(id);

        if (sucesso) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listarAtendimentos")
    public ResponseEntity<List<Atendimento>> listarAtendimento() {
        List<Atendimento> atendimentos = atendimentoService.listarAtentimento();
        return new ResponseEntity<>(atendimentos, HttpStatus.OK);
    }
}
