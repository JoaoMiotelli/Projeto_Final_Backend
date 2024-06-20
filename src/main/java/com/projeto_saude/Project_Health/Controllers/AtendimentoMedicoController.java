package com.projeto_saude.Project_Health.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projeto_saude.Project_Health.Models.AtendimentoMedico;
import com.projeto_saude.Project_Health.Services.AtendimentoMedicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoMedicoController {

    @Autowired
    private AtendimentoMedicoService atendimentoService;

    @GetMapping
    public List<AtendimentoMedico> getAllAtendimentos() {
        return atendimentoService.getAllAtendimentos();
    }

    @GetMapping("/{id}")
    public Optional<AtendimentoMedico> getAtendimentoById(@PathVariable Long id) {
        return atendimentoService.getAtendimentoById(id);
    }

    @PostMapping
    public AtendimentoMedico createAtendimento(@RequestBody AtendimentoMedico atendimento) {
        return atendimentoService.createAtendimento(atendimento);
    }

    @PutMapping("/{id}")
    public AtendimentoMedico updateAtendimento(@PathVariable Long id, @RequestBody AtendimentoMedico atendimento) {
        return atendimentoService.updateAtendimento(id, atendimento);
    }

    @DeleteMapping("/{id}")
    public void deleteAtendimento(@PathVariable Long id) {
        atendimentoService.deleteAtendimento(id);
    }
}


