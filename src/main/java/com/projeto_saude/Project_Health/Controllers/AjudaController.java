package com.projeto_saude.Project_Health.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ajuda")
public class AjudaController {

    @GetMapping
    public Map<String, Object> getAjuda() {
        Map<String, Object> ajuda = new HashMap<>();
        ajuda.put("Estudantes", Arrays.asList("João Victor Miotelli Vitali", "Theo Grings Gomide"));
        ajuda.put("Projeto", "Project Health");
        ajuda.put("Tema", "Saúde e Bem-estar: Gerenciamento de medicamentos, mapeamento de atendimentos médicos, recomendações médicas");
        return ajuda;
    }
}