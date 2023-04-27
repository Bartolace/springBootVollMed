package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.records.medico.DadosDetalhamentoMedico;
import med.voll.api.entity.Medico;
import med.voll.api.records.medico.DadosAtualiozacaoMedico;
import med.voll.api.records.medico.DadosCadastroMedico;
import med.voll.api.records.medico.DadosListagemMedicos;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        Medico newMedico = repository.save(new Medico(dados));

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(newMedico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(newMedico));//201
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listar(Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
        return ResponseEntity.ok(page);//200
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualiozacaoMedico dados ){
         var medico = repository.getReferenceById(dados.id());
         medico.atualizarInformacoes(dados);
         return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));//200
    }
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluirLogico();
        return ResponseEntity.noContent().build();//204
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));//204
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
