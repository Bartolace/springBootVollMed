package med.voll.api.records.consulta;

import jakarta.validation.constraints.NotNull;
import med.voll.api.enums.consulta.MotivoCancelamento;

public record DadosCancelamentoConsulta(
        Long idConsulta,
        @NotNull
        MotivoCancelamento motivo
) {
}
