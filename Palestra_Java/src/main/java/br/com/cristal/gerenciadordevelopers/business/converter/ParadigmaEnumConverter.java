package br.com.cristal.gerenciadordevelopers.business.converter;

import br.com.cristal.gerenciadordevelopers.business.enumerator.ParadgmaEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter
public class ParadigmaEnumConverter implements AttributeConverter<ParadgmaEnum, String> {


    @Override
    public String convertToDatabaseColumn(ParadgmaEnum paradgmaEnum) {
        return Optional.ofNullable(paradgmaEnum.getDescricao()).orElseThrow(() -> new RuntimeException("paradigma vazio"));
    }

    @Override
    public ParadgmaEnum convertToEntityAttribute(String s) {
        return Optional.ofNullable(ParadgmaEnum.buscaPorDescricao(s)).orElseThrow(() -> new RuntimeException("paradigma cadastrado nao mapeadado : " + s));
    }
}
