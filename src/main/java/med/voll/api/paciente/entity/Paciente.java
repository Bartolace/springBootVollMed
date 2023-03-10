package med.voll.api.paciente.entity;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.medico.entity.Endereco;
import med.voll.api.paciente.records.AtualizaDadosPaciente;
import med.voll.api.paciente.records.DadosCadastroPaciente;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = false;
    }

    public void atualizaPaciente(AtualizaDadosPaciente dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco = dados.endereco();
        }
    }

    public void excluirLogico() {
        this.ativo = false;
    }
}
