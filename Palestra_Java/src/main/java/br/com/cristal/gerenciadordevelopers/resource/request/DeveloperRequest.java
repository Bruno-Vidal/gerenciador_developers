package br.com.cristal.gerenciadordevelopers.resource.request;

import br.com.cristal.gerenciadordevelopers.business.enumerator.CargoEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DeveloperRequest {
    private String nome;
    private String cpf;
    private CargoEnum cargo;
    private List<LinguagemDeveloperRequest> linguagens;
}
