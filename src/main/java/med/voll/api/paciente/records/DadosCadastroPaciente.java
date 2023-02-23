package med.voll.api.paciente.records;

import med.voll.api.medico.records.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf,
                                    DadosEndereco endereco) {
}
