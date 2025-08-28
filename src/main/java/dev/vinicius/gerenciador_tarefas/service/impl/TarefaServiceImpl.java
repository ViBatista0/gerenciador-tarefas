package dev.vinicius.gerenciador_tarefas.service.impl;

import dev.vinicius.gerenciador_tarefas.controller.request.TarefaRequestDto;
import dev.vinicius.gerenciador_tarefas.controller.response.TarefaDto;
import dev.vinicius.gerenciador_tarefas.model.Tarefa;
import dev.vinicius.gerenciador_tarefas.repository.TarefaRepository;
import dev.vinicius.gerenciador_tarefas.service.TarefaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    @Override
    public TarefaDto criarTarefa(TarefaRequestDto dto) {
        Tarefa tarefa = Tarefa.builder()
                .nomeTarefa(dto.getNomeTarefa())
                .dataEntrega(LocalDateTime.now())
                .responsavelEntrega(dto.getResponsavelEntrega())
                .build();

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        return TarefaDto.builder()
                .id(tarefaSalva.getId())
                .nomeTarefa(tarefaSalva.getNomeTarefa())
                .dataEntrega(tarefaSalva.getDataEntrega())
                .responsavelEntrega(tarefaSalva.getResponsavelEntrega())
                .build();
    }

    @Override
    public TarefaDto editarTarefa(Long tarefaId, TarefaRequestDto dto) {

        Tarefa tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(()-> new EntityNotFoundException("Tarefa não encontrada para o id informado"));

        tarefa.setNomeTarefa(dto.getNomeTarefa());
        tarefa.setDataEntrega(LocalDateTime.now());
        tarefa.setResponsavelEntrega(dto.getResponsavelEntrega());

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        return TarefaDto.builder()
                .id(tarefaSalva.getId())
                .nomeTarefa(tarefaSalva.getNomeTarefa())
                .dataEntrega(tarefaSalva.getDataEntrega())
                .responsavelEntrega(tarefaSalva.getResponsavelEntrega())
                .build();
    }
}
