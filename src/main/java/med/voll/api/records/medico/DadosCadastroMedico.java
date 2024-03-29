package med.voll.api.records.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Especialidade;

public record DadosCadastroMedico(
    @NotBlank //apenas para strings
    String nome,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String telefone,
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm,
    @NotNull
    Especialidade especialidade,
    @NotNull @Valid
    DadosEndereco endereco) {

}
//valid tbm marca como objeto a ser validado;