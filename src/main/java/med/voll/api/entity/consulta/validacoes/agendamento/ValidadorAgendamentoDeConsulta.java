package med.voll.api.entity.consulta.validacoes.agendamento;

import med.voll.api.records.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsulta dados);
}
