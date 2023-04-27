package med.voll.api.records.consulta;

import med.voll.api.entity.consulta.Consulta;
import med.voll.api.enums.consulta.MotivoCancelamento;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data,
        MotivoCancelamento motivoCancelamento) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData(),
                consulta.getMotivoCancelamento());
    }
}
