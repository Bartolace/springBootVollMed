package med.voll.api.paciente.records;

import jakarta.validation.constraints.NotNull;
import med.voll.api.medico.entity.Endereco;

public record AtualizaDadosPaciente(
        @NotNull
         Long id,
         String nome,
         String telefone,
         Endereco endereco
) {
}
