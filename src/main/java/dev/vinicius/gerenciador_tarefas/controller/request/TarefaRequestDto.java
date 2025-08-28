package dev.vinicius.gerenciador_tarefas.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaRequestDto {

    @NotNull(message = "O nome da tarefa é obrigatório")
    @JsonProperty("nome_tarefa")
    private String nomeTarefa;

    @NotNull(message = "O responsável pela entrega é obrigatório")
    @JsonProperty("responsavel_entrega")
    private String responsavelEntrega;
}

