package dev.vinicius.gerenciador_tarefas.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "tarefa")
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_tarefa", length = 100, nullable = false)
    private String nomeTarefa;

    @Column(name = "data_entrega", nullable = false)
    private LocalDateTime dataEntrega;

    @Column(name = "responsavel_entrega", length = 100, nullable = false)
    private String responsavelEntrega;
}
