package br.com.techx.aula_sb.controller;


import br.com.techx.aula_sb.model.Aluno;
import br.com.techx.aula_sb.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAll(){
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id){
        return alunoService.findByID(id);
    }
    @PostMapping
    public Aluno save(@RequestBody Aluno aluno){
        return alunoService.save(aluno);
    }
    @GetMapping("/buscar")
    public List<Aluno> buscarPorNome(@RequestParam String nome){
        return alunoService.findByNome(nome);
    }
    @GetMapping("/ra")
    public String consultarRa(){
        return "O RA do aluno Iury é 1234";
    }
}
