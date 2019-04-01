package br.com.cristal.gerenciadordevelopers.business.service.impl;

import br.com.cristal.gerenciadordevelopers.business.embedded.DeveloperLinguagemId;
import br.com.cristal.gerenciadordevelopers.business.enumerator.NivelEnum;
import br.com.cristal.gerenciadordevelopers.business.model.Developer;
import br.com.cristal.gerenciadordevelopers.business.model.DeveloperLinguagem;
import br.com.cristal.gerenciadordevelopers.business.model.Linguagem;
import br.com.cristal.gerenciadordevelopers.business.repository.DeveloperRepository;
import br.com.cristal.gerenciadordevelopers.business.repository.LinguagemRepository;
import br.com.cristal.gerenciadordevelopers.business.service.DeveloperService;
import br.com.cristal.gerenciadordevelopers.resource.request.DeveloperRequest;
import br.com.cristal.gerenciadordevelopers.resource.request.LinguagemDeveloperRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private DeveloperRepository developerRepository;
    private LinguagemRepository linguagemRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, LinguagemRepository linguagemRepository) {
        this.developerRepository = developerRepository;
        this.linguagemRepository = linguagemRepository;
    }

    @Override
    public List<Developer> buscarTodosDevelopers() {
        return developerRepository.findAll();
    }

    @Override
    public Developer buscarPeloId(Long id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Developer com id " + id + " não encontrado"));
    }

    @Override
    public Developer criarDeveloper(DeveloperRequest request) {
        Developer developer = buildarDeveloper(request,new Developer());
        developerRepository.save(developer);
        return developer;
    }

    public Developer atualizarDeveloper(Long id,DeveloperRequest request) {
        Developer developer = developerRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao Atualizar Developer com id " + id + " não existe"));
        buildarDeveloper(request,developer);
        return developerRepository.save(developer);
    }

    @Override
    public void deletarDeveloper(Long id) {
        developerRepository.deleteById(id);
    }

    private Developer buildarDeveloper(DeveloperRequest request,Developer developer) {
        List<DeveloperLinguagem> linguagems = buildarLinguagens(request.getLinguagens(), developer);
        developer.setLinguagens(linguagems);
        developer.setNome(request.getNome());
        developer.setCpf(request.getCpf());
        developer.setCargo(request.getCargo());
        return developer;
    }

    private List<DeveloperLinguagem> buildarLinguagens(List<LinguagemDeveloperRequest> linguagens,Developer developer) {
        List<Linguagem> linguagensEntity = linguagemRepository.findAllById(linguagens.stream().map((LinguagemDeveloperRequest::getId)).collect(Collectors.toList()));

        return linguagensEntity.stream().map(linguagem -> {
            return DeveloperLinguagem.builder()
                                .developerLinguagemId(DeveloperLinguagemId.builder().linguagemId(linguagem.getId()).developerId(developer.getId()).build())
                                .developer(developer)
                                .linguagem(linguagem)
                                .nivel(NivelEnum.buscaPorCodigo(linguagens.stream()
                                                                            .filter(linguagemDeveloperRequest -> linguagemDeveloperRequest.getId().equals(linguagem.getId())).findFirst().orElse(null).getNivel()))
                              .build();
        }).collect(Collectors.toList());
    }

}
