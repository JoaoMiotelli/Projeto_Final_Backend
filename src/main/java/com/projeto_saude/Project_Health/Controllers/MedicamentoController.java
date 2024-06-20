package com.projeto_saude.Project_Health.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projeto_saude.Project_Health.Models.Medicamento;
import com.projeto_saude.Project_Health.Services.MedicamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoService.getAllMedicamentos();
    }

    @GetMapping("/{id}")
    public Optional<Medicamento> getMedicamentoById(@PathVariable Long id) {
        return medicamentoService.getMedicamentoById(id);
    }

    @PostMapping
    public Medicamento createMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoService.createMedicamento(medicamento);
    }

    @PutMapping("/{id}")
    public Medicamento updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        return medicamentoService.updateMedicamento(id, medicamento);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicamento(@PathVariable Long id) {
        medicamentoService.deleteMedicamento(id);
    }
}