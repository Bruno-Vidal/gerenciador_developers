package br.com.cristal.gerenciadordevelopers.resource.response;

import br.com.cristal.gerenciadordevelopers.business.dto.LinguagemDeveloperDTO;
import br.com.cristal.gerenciadordevelopers.business.enumerator.CargoEnum;
import br.com.cristal.gerenciadordevelopers.business.model.Developer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DeveloperResponse {
    private Long id;
    private String nome;
    private String cpf;
    private CargoEnum cargo;
    private List<LinguagemDeveloperDTO> linguagens;

    public static DeveloperResponse mapear(Developer developer) {
        return DeveloperResponse.builder()
                                    .id(developer.getId())
                                    .nome(developer.getNome())
                                    .cpf(developer.getCpf())
                                    .cargo(developer.getCargo())
                                    .linguagens(developer.buscarLinguagens())
                                .build();
    }
}
