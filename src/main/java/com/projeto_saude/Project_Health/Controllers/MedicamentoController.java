package com.projeto_saude.Project_Health.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto_saude.Project_Health.Models.Medicamento;
import com.projeto_saude.Project_Health.Services.MedicamentoService;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public Page<Medicamento> getAllMedicamentos(Pageable pageable) {
        return medicamentoService.getAllMedicamentos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Long id) {
        Optional<Medicamento> medicamento = medicamentoService.getMedicamentoById(id);
        return medicamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medicamento> createMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento savedMedicamento = medicamentoService.createMedicamento(medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedicamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        Optional<Medicamento> existingMedicamento = medicamentoService.getMedicamentoById(id);
        if (existingMedicamento.isPresent()) {
            medicamento.setId(id);
            Medicamento updatedMedicamento = medicamentoService.createMedicamento(medicamento);
            return ResponseEntity.ok(updatedMedicamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        medicamentoService.deleteMedicamento(id);
        return ResponseEntity.noContent().build();
    }
}
