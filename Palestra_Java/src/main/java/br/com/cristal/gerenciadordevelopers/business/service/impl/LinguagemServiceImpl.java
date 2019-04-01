package br.com.cristal.gerenciadordevelopers.business.service.impl;

import br.com.cristal.gerenciadordevelopers.business.model.Linguagem;
import br.com.cristal.gerenciadordevelopers.business.repository.LinguagemRepository;
import br.com.cristal.gerenciadordevelopers.business.service.LinguagemService;
import br.com.cristal.gerenciadordevelopers.resource.request.LinguagemRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinguagemServiceImpl implements LinguagemService {

    private LinguagemRepository repository;

    public LinguagemServiceImpl(LinguagemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Linguagem> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Linguagem buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Linguagem não encontrada"));
    }

    @Override
    public Linguagem criar(LinguagemRequest request) {

        return repository.save(buildarLinguagem(request));
    }

    private Linguagem buildarLinguagem(LinguagemRequest request) {
        return Linguagem.builder()
                            .nome(request.getNome())
                            .paradigma(request.getParadigma())
                            .tipada(request.getTipada())
                        .build();
    }

    @Override
    public Linguagem atualizar(LinguagemRequest request, Long id) {
        Linguagem linguagem = buildarLinguagem(request);
        linguagem.setId(id);
        return repository.save(linguagem);
    }

    @Override
    public void deletar(Long id) {
         repository.deleteById(id);
    }
}
