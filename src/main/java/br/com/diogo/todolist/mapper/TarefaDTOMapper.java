package br.com.diogo.todolist.mapper;


import br.com.diogo.todolist.dto.TarefaDTO;
import br.com.diogo.todolist.entity.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaDTOMapper {

    public TarefaDTO toDTO(Tarefa tarefas) {
        return new TarefaDTO(
                tarefas.getId(),
                tarefas.getTarefa(),
                tarefas.getConcluida()
        );
    }

    public Tarefa toEntity(TarefaDTO dto) {
        return new Tarefa(
                dto.id(),
                dto.tarefa(),
                dto.concluida()
        );
    }


}
