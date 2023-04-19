package med.voll.api.entity.consulta.services;

import med.voll.api.infra.exceptions.ValidacaoException;
import med.voll.api.records.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidarHorarioFuncionamentoClinica {

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dados.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Consulta fora do Horário de funcionamento da clínica");
        }
    }
}
