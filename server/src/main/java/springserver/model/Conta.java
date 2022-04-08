package springserver.model;

import lombok.Data;
import springserver.model.enumerators.ContaTipo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Conta {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "O campo 'user' é obrigatório")
    private User user;

    @Size(max = 255)
    @NotNull(message = "O campo 'numero' é obrigatório")
    private String numero;

    @Size(max = 255)
    @NotNull(message = "O campo 'agencia' é obrigatório")
    private String agencia;

    @Size(max = 255)
    @NotNull(message = "O campo 'banco' é obrigatório")
    private String banco;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo 'tipo' é obrigatório")
    private ContaTipo tipoconta;

}