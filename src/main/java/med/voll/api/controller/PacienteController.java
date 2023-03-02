package med.voll.api.controller;

import med.voll.api.paciente.repository.PacienteRepository;
import med.voll.api.paciente.records.DadosCadastroPaciente;
import med.voll.api.paciente.entity.Paciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados ){
        repository.save(new Paciente(dados));
    }
}
