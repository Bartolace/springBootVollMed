package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.records.DadosListagemMedicos;
import med.voll.api.paciente.records.DadosListagemPacientes;
import med.voll.api.paciente.repository.PacienteRepository;
import med.voll.api.paciente.records.DadosCadastroPaciente;
import med.voll.api.paciente.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados ){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listar(@PageableDefault(size = 10, sort = "nome",direction = Sort.Direction.DESC)
                                                   Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPacientes::new);
    }
}
