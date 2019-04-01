package br.com.cristal.gerenciadordevelopers.business.repository;

import br.com.cristal.gerenciadordevelopers.business.model.Linguagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguagemRepository extends JpaRepository<Linguagem,Long> {
}
