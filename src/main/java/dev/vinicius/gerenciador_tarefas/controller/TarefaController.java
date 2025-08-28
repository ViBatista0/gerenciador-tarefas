package dev.vinicius.gerenciador_tarefas.controller;

import dev.vinicius.gerenciador_tarefas.controller.request.TarefaRequestDto;
import dev.vinicius.gerenciador_tarefas.controller.response.TarefaDto;
import dev.vinicius.gerenciador_tarefas.model.Tarefa;
import dev.vinicius.gerenciador_tarefas.repository.TarefaRepository;
import dev.vinicius.gerenciador_tarefas.service.TarefaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;
    private final TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<TarefaDto> criarTarefa(@RequestBody TarefaRequestDto dto){
        return  ResponseEntity.ok().body(tarefaService.criarTarefa(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> exibirTarefaPorId(Long tarefaId){
        Tarefa tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(()-> new EntityNotFoundException("Nenhuma tarefa encontrada para o id informado"));

        TarefaDto tarefaDto = TarefaDto.builder()
                .id(tarefa.getId())
                .nomeTarefa(tarefa.getNomeTarefa())
                .dataEntrega(tarefa.getDataEntrega())
                .responsavelEntrega(tarefa.getResponsavelEntrega())
                .build();

        return ResponseEntity.ok().body(tarefaDto);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDto>> criarTarefa(){

        List<Tarefa> tarefa = tarefaRepository.findAll();

        List<TarefaDto> tarefasDto = tarefa.stream()
                .map(t -> new TarefaDto(t.getId(), t.getNomeTarefa(), t.getDataEntrega(), t.getResponsavelEntrega()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(tarefasDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDto> editarTarefa(@RequestBody TarefaRequestDto dto, @PathVariable Long id){
        return  ResponseEntity.ok().body(tarefaService.editarTarefa(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaRepository.deleteById(id);
    }

}
