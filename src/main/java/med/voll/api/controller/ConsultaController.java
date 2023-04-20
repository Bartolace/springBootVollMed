package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.entity.consulta.services.AgendaDeConsultas;
import med.voll.api.records.consulta.DadosAgendamentoConsulta;
import med.voll.api.records.consulta.DadosDetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agendaDeConsultaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        var dto = agendaDeConsultaService.agendar(dados);
        return ResponseEntity.ok(dto);
    }
}
