package br.com.cristal.gerenciadordevelopers.business.converter;

import br.com.cristal.gerenciadordevelopers.business.enumerator.CargoEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter
public class CargoEnumConverter implements AttributeConverter<CargoEnum,String> {
    @Override
    public String convertToDatabaseColumn(CargoEnum cargoEnum) {
        return Optional
                .ofNullable(cargoEnum.getDescricao())
                .orElseThrow(() -> new RuntimeException("cargo vazio"));
    }

    @Override
    public CargoEnum convertToEntityAttribute(String s) {
        return Optional
                .ofNullable(CargoEnum.buscaPorDescricao(s))
                .orElseThrow(() -> new RuntimeException("cargo cadastrado nao mapeadado : " + s));
    }
}
