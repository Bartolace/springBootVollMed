package med.voll.api.records.medico;

import med.voll.api.entity.Endereco;
import med.voll.api.entity.Medico;
import med.voll.api.enums.Especialidade;

public record DadosDetalhamentoMedico(
    Long id,
    String nome,
    String email,
    String telefone,
    String crm,
    Especialidade especialidade,
    Endereco endereco){

     public DadosDetalhamentoMedico (Medico medico){
         this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(),
         medico.getEndereco());
     }
}
