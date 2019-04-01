package br.com.cristal.gerenciadordevelopers.business.model;

import br.com.cristal.gerenciadordevelopers.business.converter.CargoEnumConverter;
import br.com.cristal.gerenciadordevelopers.business.dto.LinguagemDeveloperDTO;
import br.com.cristal.gerenciadordevelopers.business.enumerator.CargoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "developers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Convert(converter = CargoEnumConverter.class)
    private CargoEnum cargo;

    @OneToMany(mappedBy = "developer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DeveloperLinguagem> linguagens = new ArrayList<>();

    public void setLinguagens(List<DeveloperLinguagem> linguagens) {
        this.linguagens.clear();
        this.linguagens.addAll(linguagens);
    }

    public List<LinguagemDeveloperDTO> buscarLinguagens() {
        return linguagens.stream()
                .map(DeveloperLinguagem::getLinguagemDeveloperDTO)
                .collect(Collectors.toList());
    }
}
