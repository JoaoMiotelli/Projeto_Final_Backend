package com.projeto_saude.Project_Health.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto_saude.Project_Health.Models.AtendimentoMedico;
import com.projeto_saude.Project_Health.Services.AtendimentoMedicoService;
import java.util.Optional;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoMedicoController {

    @Autowired
    private AtendimentoMedicoService atendimentoMedicoService;

    @GetMapping
    public Page<AtendimentoMedico> getAllAtendimentos(Pageable pageable) {
        return atendimentoMedicoService.getAllAtendimentos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoMedico> getAtendimentoById(@PathVariable Long id) {
        Optional<AtendimentoMedico> atendimento = atendimentoMedicoService.getAtendimentoById(id);
        return atendimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtendimentoMedico> createAtendimento(@RequestBody AtendimentoMedico atendimento) {
        AtendimentoMedico savedAtendimento = atendimentoMedicoService.createAtendimento(atendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAtendimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoMedico> updateAtendimento(@PathVariable Long id, @RequestBody AtendimentoMedico atendimento) {
        Optional<AtendimentoMedico> existingAtendimento = atendimentoMedicoService.getAtendimentoById(id);
        if (existingAtendimento.isPresent()) {
            atendimento.setId(id);
            AtendimentoMedico updatedAtendimento = atendimentoMedicoService.createAtendimento(atendimento);
            return ResponseEntity.ok(updatedAtendimento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable Long id) {
        atendimentoMedicoService.deleteAtendimento(id);
        return ResponseEntity.noContent().build();
    }
}


