
package br.com.techx.aula_sb.service;

import br.com.techx.aula_sb.dto.AlunoRequest;
import br.com.techx.aula_sb.dto.AlunoResponse;
import br.com.techx.aula_sb.model.Aluno;
import br.com.techx.aula_sb.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoResponse> findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        List<AlunoResponse> respostas = new ArrayList<>();

        for (Aluno aluno : alunos) {
            respostas.add(toResponse(aluno));
        }

        return respostas;
    }

    public AlunoResponse create(AlunoRequest request) {
        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setIdade(request.getIdade());
        aluno.setRa(request.getRa());

        Aluno salvo = alunoRepository.save(aluno);
        return toResponse(salvo);
    }

    public Optional<AlunoResponse> findById(Long id) {
        Optional<Aluno> optional = alunoRepository.findById(id);

        if (optional.isPresent()) {
            Aluno aluno = optional.get();
            return Optional.of(toResponse(aluno));
        } else {
            return Optional.empty();
        }
    }

    public void update(Long id, AlunoRequest request) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(request.getNome());
        aluno.setIdade(request.getIdade());
        aluno.setRa(request.getRa());

        alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado");
        }

        alunoRepository.deleteById(id);
    }

    private AlunoResponse toResponse(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getIdade(),
                aluno.getRa()
        );
    }
}
