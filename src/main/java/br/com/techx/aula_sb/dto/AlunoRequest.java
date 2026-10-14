
package br.com.techx.aula_sb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoRequest {
    private String nome;
    private int idade;
    private int ra;
}
