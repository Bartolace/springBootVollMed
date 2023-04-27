package med.voll.api.entity.consulta.validacoes.cancelamento;

import med.voll.api.entity.consulta.Consulta;
import med.voll.api.infra.exceptions.ValidacaoException;
import med.voll.api.records.consulta.DadosCancelamentoConsulta;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaCancelamento implements ValidadorCancelamentoConsulta {

    @Autowired
    ConsultaRepository repository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        Consulta consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferençaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if(diferençaEmHoras < 24){
            throw new ValidacaoException("Canelamento de consulta deve ter antecedência de 24 horas");
        }
    }
}
