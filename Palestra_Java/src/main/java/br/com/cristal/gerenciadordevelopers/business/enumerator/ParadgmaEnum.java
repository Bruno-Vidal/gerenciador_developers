package br.com.cristal.gerenciadordevelopers.business.enumerator;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ParadgmaEnum {
    ORIENTADO_OBJETOS("POO","Orientada a objetos"),
    ESTRUTURADO("PE","Estruturada");

    private String sigla;
    private String descricao;
    ParadgmaEnum(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public static ParadgmaEnum buscaPorDescricao(String descricao) {
        return Arrays.stream(values())
                        .filter((value) -> value.getDescricao().equals(descricao))
                        .findFirst()
                        .orElse(null);
    }
}
