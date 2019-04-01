package br.com.cristal.gerenciadordevelopers.business.service;

import br.com.cristal.gerenciadordevelopers.business.model.Linguagem;
import br.com.cristal.gerenciadordevelopers.resource.request.LinguagemRequest;

import java.util.List;

public interface LinguagemService {

    List<Linguagem> buscarTodos();

    Linguagem buscarPorId(Long id);

    Linguagem criar(LinguagemRequest request);

    Linguagem atualizar(LinguagemRequest request,Long id);

    void deletar(Long id);
}
