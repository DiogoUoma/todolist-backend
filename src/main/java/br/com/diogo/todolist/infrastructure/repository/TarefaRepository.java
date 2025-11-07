package br.com.diogo.todolist.infrastructure.repository;

import br.com.diogo.todolist.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
