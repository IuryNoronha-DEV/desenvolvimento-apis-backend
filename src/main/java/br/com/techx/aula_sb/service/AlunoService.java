package br.com.techx.aula_sb.service;

import br.com.techx.aula_sb.model.Aluno;
import br.com.techx.aula_sb.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }
}

