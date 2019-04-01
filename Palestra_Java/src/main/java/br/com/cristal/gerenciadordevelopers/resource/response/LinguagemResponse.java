package br.com.cristal.gerenciadordevelopers.resource.response;

import br.com.cristal.gerenciadordevelopers.business.enumerator.ParadgmaEnum;
import br.com.cristal.gerenciadordevelopers.business.model.Linguagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinguagemResponse {
    private Long id;
    private String nome;
    private Boolean tipada;
    private ParadgmaEnum paradigma;

    public static LinguagemResponse mapear(Linguagem linguagem) {
        return LinguagemResponse.builder()
                                    .id(linguagem.getId())
                                    .nome(linguagem.getNome())
                                    .paradigma(linguagem.getParadigma())
                                    .tipada(linguagem.getTipada())
                                .build();
    }

}
