package br.com.cristal.gerenciadordevelopers.business.enumerator;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum NivelEnum {
    BASICO("Básico",1),
    INTERMEDIARIO("Intermediario",2),
    AVANCADO("Avançado",3);

    private String descricao;
    private Integer codigo;
    NivelEnum(String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public static NivelEnum buscaPorCodigo(Integer codigo) {
       return Arrays.stream(values())
                .filter((value) -> value.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}
