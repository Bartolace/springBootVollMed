package med.voll.api.records.paciente;

import med.voll.api.entity.Paciente;

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
