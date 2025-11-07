package br.com.diogo.todolist.api.controller;

import br.com.diogo.todolist.dto.TarefaDTO;
import br.com.diogo.todolist.service.TarefaService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("")
    public ResponseEntity<List<TarefaDTO>> listar() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @PostMapping("")
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity.ok(tarefaService.criarTarefa(tarefaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizaTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity.ok(tarefaService.atualizaTarefa(id, tarefaDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

}
