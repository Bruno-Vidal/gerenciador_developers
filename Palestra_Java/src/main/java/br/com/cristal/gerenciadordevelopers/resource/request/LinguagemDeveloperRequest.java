package br.com.cristal.gerenciadordevelopers.resource.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinguagemDeveloperRequest {
    private Long id;
    private Integer nivel;
}
