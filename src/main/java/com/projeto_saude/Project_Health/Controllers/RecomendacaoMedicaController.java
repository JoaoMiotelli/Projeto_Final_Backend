package com.projeto_saude.Project_Health.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto_saude.Project_Health.Models.RecomendacaoMedica;
import com.projeto_saude.Project_Health.Services.RecomendacaoMedicaService;
import java.util.Optional;

@RestController
@RequestMapping("/recomendacoes")
public class RecomendacaoMedicaController {

    @Autowired
    private RecomendacaoMedicaService recomendacaoMedicaService;

    @GetMapping
    public Page<RecomendacaoMedica> getAllRecomendacoes(Pageable pageable) {
        return recomendacaoMedicaService.getAllRecomendacoes(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecomendacaoMedica> getRecomendacaoById(@PathVariable Long id) {
        Optional<RecomendacaoMedica> recomendacao = recomendacaoMedicaService.getRecomendacaoById(id);
        return recomendacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RecomendacaoMedica> createRecomendacao(@RequestBody RecomendacaoMedica recomendacao) {
        RecomendacaoMedica savedRecomendacao = recomendacaoMedicaService.createRecomendacao(recomendacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecomendacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecomendacaoMedica> updateRecomendacao(@PathVariable Long id, @RequestBody RecomendacaoMedica recomendacao) {
        Optional<RecomendacaoMedica> existingRecomendacao = recomendacaoMedicaService.getRecomendacaoById(id);
        if (existingRecomendacao.isPresent()) {
            recomendacao.setId(id);
            RecomendacaoMedica updatedRecomendacao = recomendacaoMedicaService.createRecomendacao(recomendacao);
            return ResponseEntity.ok(updatedRecomendacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecomendacao(@PathVariable Long id) {
        recomendacaoMedicaService.deleteRecomendacao(id);
        return ResponseEntity.noContent().build();
    }
}

