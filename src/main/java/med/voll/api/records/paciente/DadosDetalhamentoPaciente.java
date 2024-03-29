package med.voll.api.records.paciente;

import med.voll.api.entity.Endereco;
import med.voll.api.entity.Paciente;

public record DadosDetalhamentoPaciente(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco,
        Boolean ativo
) {
    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(),
                paciente.getEndereco(), paciente.getAtivo());
    }
}
