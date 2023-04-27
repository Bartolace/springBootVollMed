package med.voll.api.entity.consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.entity.Medico;
import med.voll.api.entity.Paciente;
import med.voll.api.enums.consulta.MotivoCancelamento;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;
    @Column(name = "motivo_cancelamento")
    private MotivoCancelamento motivoCancelamento;

    public Consulta(Medico medico, Paciente paciente, LocalDateTime data, MotivoCancelamento motivoCancelamento) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.motivoCancelamento = motivoCancelamento.NENHUM;
    }

    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }
}
