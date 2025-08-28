package dev.vinicius.gerenciador_tarefas.service;

import dev.vinicius.gerenciador_tarefas.controller.request.TarefaRequestDto;
import dev.vinicius.gerenciador_tarefas.controller.response.TarefaDto;

public interface TarefaService {

    TarefaDto criarTarefa(TarefaRequestDto dto);
    TarefaDto editarTarefa(Long tarefaId, TarefaRequestDto dto);

}
