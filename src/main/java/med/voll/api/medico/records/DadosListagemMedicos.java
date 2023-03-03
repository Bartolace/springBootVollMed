package med.voll.api.medico.records;

import med.voll.api.medico.entity.Medico;
import med.voll.api.medico.enums.Especialidade;

public record DadosListagemMedicos(

        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DadosListagemMedicos (Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
