package br.com.diogo.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TarefaDTO(
        Long id,
        @NotBlank(message = "A tarefa não pode estar vazia")
        String tarefa,
        @NotNull(message = "O status não pode ser nulo")
        Boolean concluida
) {
}
