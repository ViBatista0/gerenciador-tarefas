package dev.vinicius.gerenciador_tarefas.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome_tarefa")
    private String nomeTarefa;

    @JsonProperty("data_entrega")
    private LocalDateTime dataEntrega;

    @JsonProperty("responsavel_entrega")
    private String responsavelEntrega;
}
