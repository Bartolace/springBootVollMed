package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.entity.Medico;
import med.voll.api.medico.records.DadosCadastroMedico;
import med.voll.api.medico.records.DadosListagemMedicos;
import med.voll.api.medico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedicos> listar(){
        return repository.findAll().stream().map(DadosListagemMedicos::new).toList();
    }

}
