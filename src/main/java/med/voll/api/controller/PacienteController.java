package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.records.paciente.AtualizaDadosPaciente;
import med.voll.api.records.paciente.DadosDetalhamentoPaciente;
import med.voll.api.records.paciente.DadosListagemPacientes;
import med.voll.api.repository.PacienteRepository;
import med.voll.api.records.paciente.DadosCadastroPaciente;
import med.voll.api.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
        Paciente paciente = repository.save(new Paciente(dados));
        var uri = uriBuilder.path("pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));//201
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPacientes>> listar( Pageable paginacao ) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPacientes::new);
        return ResponseEntity.ok(page);//200
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaDadosPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizaPaciente(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluirLogico();
        return ResponseEntity.noContent().build();
    }

}

//Não retornar a entity diretamente
