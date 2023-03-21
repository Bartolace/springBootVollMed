package med.voll.api.records.medico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualiozacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
