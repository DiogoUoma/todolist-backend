package br.com.diogo.todolist.service;

import br.com.diogo.todolist.dto.TarefaDTO;
import br.com.diogo.todolist.entity.Tarefa;
import br.com.diogo.todolist.infrastructure.repository.TarefaRepository;
import br.com.diogo.todolist.mapper.TarefaDTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaDTOMapper tarefaMapper;

    public TarefaService(TarefaRepository tarefaRepository, TarefaDTOMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    public List<TarefaDTO> listarTodas() {
        return tarefaRepository.findAll()
                .stream()
                .map(tarefaMapper::toDTO)
                .toList();
    }

    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa novaTarefa = tarefaMapper.toEntity(tarefaDTO);
        novaTarefa.setId(null);
        Tarefa salva = tarefaRepository.save(novaTarefa);
        return tarefaMapper.toDTO(salva);
    }

    public TarefaDTO atualizaTarefa(Long id, TarefaDTO tarefaDTO) {
        Tarefa tarefaexiste = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefaexiste.setTarefa(tarefaDTO.tarefa());
        tarefaexiste.setConcluida(tarefaDTO.concluida());
        return tarefaMapper.toDTO(tarefaRepository.save(tarefaexiste));
    }


    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

}
