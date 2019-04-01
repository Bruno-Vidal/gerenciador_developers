package br.com.cristal.gerenciadordevelopers.business.service;

import br.com.cristal.gerenciadordevelopers.business.model.Developer;
import br.com.cristal.gerenciadordevelopers.resource.request.DeveloperRequest;

import java.util.List;

public interface DeveloperService {

    List<Developer> buscarTodosDevelopers();

    Developer buscarPeloId(Long id);

    Developer criarDeveloper(DeveloperRequest request);

    Developer atualizarDeveloper(Long id, DeveloperRequest request);

    void deletarDeveloper(Long id);
}
