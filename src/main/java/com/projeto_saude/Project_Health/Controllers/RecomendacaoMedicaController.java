package com.projeto_saude.Project_Health.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projeto_saude.Project_Health.Models.RecomendacaoMedica;
import com.projeto_saude.Project_Health.Services.RecomendacaoMedicaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recomendacoes-medicas")
public class RecomendacaoMedicaController {

    @Autowired
    private RecomendacaoMedicaService recomendacaoMedicaService;

    @GetMapping
    public List<RecomendacaoMedica> getAllRecomendacoesMedicas() {
        return recomendacaoMedicaService.getAllRecomendacoesMedicas();
    }

    @GetMapping("/{id}")
    public Optional<RecomendacaoMedica> getRecomendacaoMedicaById(@PathVariable Long id) {
        return recomendacaoMedicaService.getRecomendacaoMedicaById(id);
    }

    @PostMapping
    public RecomendacaoMedica createRecomendacaoMedica(@RequestBody RecomendacaoMedica recomendacaoMedica) {
        return recomendacaoMedicaService.createRecomendacaoMedica(recomendacaoMedica);
    }

    @PutMapping("/{id}")
    public RecomendacaoMedica updateRecomendacaoMedica(@PathVariable Long id, @RequestBody RecomendacaoMedica recomendacaoMedica) {
        return recomendacaoMedicaService.updateRecomendacaoMedica(id, recomendacaoMedica);
    }

    @DeleteMapping("/{id}")
    public void deleteRecomendacaoMedica(@PathVariable Long id) {
        recomendacaoMedicaService.deleteRecomendacaoMedica(id);
    }
}