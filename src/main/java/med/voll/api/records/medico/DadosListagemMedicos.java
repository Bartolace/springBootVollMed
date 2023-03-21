package med.voll.api.records.medico;

import med.voll.api.entity.Medico;
import med.voll.api.enums.Especialidade;

public record DadosListagemMedicos(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Boolean ativo
) {

    public DadosListagemMedicos (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(),
                medico.getAtivo());
    }
}
