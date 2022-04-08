package springserver.model;

import springserver.annotation.UniqueUsername;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
// @Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotNull(message = "{user.constraints.NotNull.message}")
    @Size(min = 4, max = 255, message = " O tamanho deve ser entre {min} e {max}")
    @UniqueUsername
    private String username;

    @NotNull
    @Size(min = 4, max = 255, message = " O tamanho deve ser entre {min} e {max}")
    private String displayname;

    @NotNull
    @Size(min = 6, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "A senha deve conter letras maiúsculas, minúsculas e números")
    private String password;

}
