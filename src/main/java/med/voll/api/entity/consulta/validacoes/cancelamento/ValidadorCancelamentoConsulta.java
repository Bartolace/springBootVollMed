package med.voll.api.entity.consulta.validacoes.cancelamento;

import med.voll.api.records.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
