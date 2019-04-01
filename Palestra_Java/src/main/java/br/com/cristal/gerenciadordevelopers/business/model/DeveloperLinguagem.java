package br.com.cristal.gerenciadordevelopers.business.model;

import br.com.cristal.gerenciadordevelopers.business.converter.NivelEnumConverter;
import br.com.cristal.gerenciadordevelopers.business.dto.LinguagemDeveloperDTO;
import br.com.cristal.gerenciadordevelopers.business.embedded.DeveloperLinguagemId;
import br.com.cristal.gerenciadordevelopers.business.enumerator.NivelEnum;
import br.com.cristal.gerenciadordevelopers.resource.response.LinguagemResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "developers_linguagens")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperLinguagem {


    @EmbeddedId
    private DeveloperLinguagemId developerLinguagemId;

    @Convert(converter = NivelEnumConverter.class)
    private NivelEnum nivel;

    @MapsId("developerId")
    @JoinColumn(name="id_developer")
    @ManyToOne
    Developer developer;

    @MapsId("linguagemId")
    @JoinColumn(name="id_linguagem")
    @ManyToOne
    Linguagem linguagem;

    public  LinguagemDeveloperDTO getLinguagemDeveloperDTO() {
        return LinguagemDeveloperDTO.builder()
                                    .linguagem(LinguagemResponse.mapear(linguagem))
                                            .nivel(nivel.getDescricao())
                                    .build();
    }
}
