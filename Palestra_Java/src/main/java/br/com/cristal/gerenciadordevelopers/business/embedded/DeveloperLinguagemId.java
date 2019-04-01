package br.com.cristal.gerenciadordevelopers.business.embedded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperLinguagemId implements Serializable {

    private Long developerId;
    private Long linguagemId;
}
