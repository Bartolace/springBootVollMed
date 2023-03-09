package med.voll.api.medico.records;

import jakarta.validation.constraints.NotNull;

public record DadosAtualiozacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
