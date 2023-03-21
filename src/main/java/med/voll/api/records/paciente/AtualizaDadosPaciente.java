package med.voll.api.records.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entity.Endereco;

public record AtualizaDadosPaciente(
        @NotNull
         Long id,
         String nome,
         String telefone,
         Endereco endereco
) {
}
