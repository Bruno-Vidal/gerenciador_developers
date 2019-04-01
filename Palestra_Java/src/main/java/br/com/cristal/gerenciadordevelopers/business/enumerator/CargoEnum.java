package br.com.cristal.gerenciadordevelopers.business.enumerator;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CargoEnum {
    ESTAGIO("Estágio"),
    TRAINEE("Trainee"),
    JUNIOR("Junior"),
    PLENO("Pleno"),
    SENIOR("Sênior"),
    ESPECIALISTA("Especialista"),
    ;

    private String descricao;
    CargoEnum(String descricao) {
        this.descricao = descricao;
    }

    public static CargoEnum buscaPorDescricao(String descricao) {
        return Arrays.stream(values())
                .filter((value) -> value.getDescricao().equals(descricao))
                .findFirst()
                .orElse(null);
    }
}
