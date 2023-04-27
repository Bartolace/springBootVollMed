package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.entity.consulta.services.AgendaDeConsultas;
import med.voll.api.records.consulta.DadosAgendamentoConsulta;
import med.voll.api.records.consulta.DadosCancelamentoConsulta;
import med.voll.api.records.consulta.DadosDetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        var dto = service.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados){
        var dto = service.cancelar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(dto));
    }


}
