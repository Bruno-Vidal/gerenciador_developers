package br.com.cristal.gerenciadordevelopers.resource.controller;

import br.com.cristal.gerenciadordevelopers.business.service.LinguagemService;
import br.com.cristal.gerenciadordevelopers.resource.request.LinguagemRequest;
import br.com.cristal.gerenciadordevelopers.resource.response.LinguagemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

    private LinguagemService service;

    public LinguagemController(LinguagemService service) {
        this.service = service;
    }

    @GetMapping
    public List<LinguagemResponse> buscarTodasLinguagens() {
        return service.buscarTodos().stream()
                .map(LinguagemResponse::mapear)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LinguagemResponse buscarPorId(@PathVariable(name = "id")Long id) {
        return LinguagemResponse.mapear(service.buscarPorId(id));
    }

    @PostMapping
    public LinguagemResponse criar(@RequestBody LinguagemRequest request) {
        return LinguagemResponse.mapear(service.criar(request));
    }

    @PutMapping("/{id}")
    public LinguagemResponse alterar(@RequestBody LinguagemRequest request, @PathVariable(name = "id") Long id) {
        return LinguagemResponse.mapear(service.atualizar(request,id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletarDeveloper(@PathVariable(name = "id") Long id) {
        service.deletar(id);
    }

}
