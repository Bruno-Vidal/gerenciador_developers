package br.com.cristal.gerenciadordevelopers.business.dto;

import br.com.cristal.gerenciadordevelopers.resource.response.LinguagemResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinguagemDeveloperDTO {
    private LinguagemResponse linguagem;
    private String nivel;
}
