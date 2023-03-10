package med.voll.api.paciente.records;

import med.voll.api.paciente.entity.Paciente;

public record DadosListagemPacientes(
        Long id,
        String nome,
        String email,
        String cpf,
        Boolean ativo
)
{
    public DadosListagemPacientes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getAtivo());
    }
}
