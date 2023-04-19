package med.voll.api.entity.consulta.services;

import med.voll.api.infra.exceptions.ValidacaoException;
import med.voll.api.records.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.ConsultaRepository;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Medico já possui outra consulta agendada nesse horário");
        }
    }
}
