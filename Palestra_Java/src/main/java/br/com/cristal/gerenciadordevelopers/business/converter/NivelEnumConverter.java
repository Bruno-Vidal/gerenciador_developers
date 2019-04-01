package br.com.cristal.gerenciadordevelopers.business.converter;

import br.com.cristal.gerenciadordevelopers.business.enumerator.NivelEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter
public class NivelEnumConverter implements AttributeConverter<NivelEnum,Integer> {
    @Override
    public Integer convertToDatabaseColumn(NivelEnum nivelEnum) {
        return Optional
                .ofNullable(nivelEnum.getCodigo())
                .orElseThrow(() -> new RuntimeException("nivel vazio"));
    }

    @Override
    public NivelEnum convertToEntityAttribute(Integer codigo) {
        return  Optional
                .ofNullable(NivelEnum.buscaPorCodigo(codigo))
                .orElseThrow(() -> new RuntimeException("cargo cadastrado nao mapeadado : " + codigo));
    }
}
