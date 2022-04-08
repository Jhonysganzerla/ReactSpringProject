package springserver.model;

import lombok.Data;
import springserver.model.enumerators.MovimentoTipo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Movimento {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @NotNull(message = "O campo valor não pode ser nulo")
    private BigDecimal valor;

    private LocalDate datavencimento;

    private LocalDate datapagamento;

    private BigDecimal valorpago;

    private String categoria;

    private String descricao;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo 'tipo' é obrigatório")
    private MovimentoTipo movimentotipo;

}
