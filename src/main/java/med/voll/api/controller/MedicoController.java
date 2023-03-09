package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.entity.Medico;
import med.voll.api.medico.records.DadosAtualiozacaoMedico;
import med.voll.api.medico.records.DadosCadastroMedico;
import med.voll.api.medico.records.DadosListagemMedicos;
import med.voll.api.medico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<DadosListagemMedicos> listar(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
    }
    @PutMapping
    @Transactional
    public void  atualizar(@RequestBody @Valid DadosAtualiozacaoMedico dados ){
         var medico = repository.getReferenceById(dados.id());
         medico.atualizarInformacoes(dados);
    }
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluirLogico();
    }

}

/*Trabalhando Pageable/ Page
* Page:
*   size=1
*   page=0
* Ordenação:
*   ?sort=nome,desc
*
* Exemplo: localhost:8080/medicos?sort=nome,desc
*
* */
