package br.com.cristal.gerenciadordevelopers.resource.controller;

import br.com.cristal.gerenciadordevelopers.business.service.DeveloperService;
import br.com.cristal.gerenciadordevelopers.resource.request.DeveloperRequest;
import br.com.cristal.gerenciadordevelopers.resource.response.DeveloperResponse;
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
@RequestMapping("/developers")
public class DeveloperController {
    private DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeveloperResponse> buscarTodosDesenvolvedores() {
        return service.buscarTodosDevelopers()
                                        .stream()
                                        .map(DeveloperResponse::mapear)
                                        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DeveloperResponse bucarPeloId(@PathVariable(name = "id") Long id) {
        return DeveloperResponse.mapear(service.buscarPeloId(id));
    }

    @PostMapping
    public DeveloperResponse criarDeveloper(@RequestBody DeveloperRequest request) {
        return DeveloperResponse.mapear(service.criarDeveloper(request));
    }

    @PutMapping("/{id}")
    public DeveloperResponse atualizarDeveloper(@PathVariable(name="id") Long id,@RequestBody DeveloperRequest request) {
        return DeveloperResponse.mapear(service.atualizarDeveloper(id,request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletarDeveloper(@PathVariable(name = "id") Long id) {
        service.deletarDeveloper(id);
    }
}
