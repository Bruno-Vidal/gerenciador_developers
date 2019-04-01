package br.com.cristal.gerenciadordevelopers.business.repository;

import br.com.cristal.gerenciadordevelopers.business.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Long> {
}
