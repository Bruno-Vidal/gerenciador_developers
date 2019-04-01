package br.com.cristal.gerenciadordevelopers.resource.request;

import br.com.cristal.gerenciadordevelopers.business.enumerator.ParadgmaEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinguagemRequest {
    private String nome;
    private Boolean tipada;
    private ParadgmaEnum paradigma;
}
