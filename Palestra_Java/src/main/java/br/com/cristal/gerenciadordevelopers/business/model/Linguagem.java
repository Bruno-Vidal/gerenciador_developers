package br.com.cristal.gerenciadordevelopers.business.model;

import br.com.cristal.gerenciadordevelopers.business.converter.ParadigmaEnumConverter;
import br.com.cristal.gerenciadordevelopers.business.enumerator.ParadgmaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "linguagens")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Linguagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Boolean tipada;

    @Convert(converter = ParadigmaEnumConverter.class)
    private ParadgmaEnum paradigma;
}
