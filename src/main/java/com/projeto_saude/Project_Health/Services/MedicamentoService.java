package com.projeto_saude.Project_Health.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto_saude.Project_Health.Models.Medicamento;
import com.projeto_saude.Project_Health.Repositories.MedicamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public List<Medicamento> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> getMedicamentoById(Long id) {
        return medicamentoRepository.findById(id);
    }

    public Medicamento createMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento updateMedicamento(Long id, Medicamento medicamento) {
        medicamento.setId(id);
        return medicamentoRepository.save(medicamento);
    }

    public void deleteMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }
}
