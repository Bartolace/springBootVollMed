package med.voll.api.entity.consulta.services;

import med.voll.api.infra.exceptions.ValidacaoException;
import med.voll.api.records.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.PacienteRepository;

public class ValidadorPacienteAtivo {
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteEstaAtivo){
                throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo");
        }
    }
}
