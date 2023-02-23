package med.voll.api.medico.records;

import med.voll.api.medico.enums.Especialidade;
import med.voll.api.medico.records.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
                                  DadosEndereco endereco) {

}
