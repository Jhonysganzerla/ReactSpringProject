package springserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springserver.model.Conta;
import springserver.model.Movimento;
import springserver.model.enumerators.MovimentoTipo;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

    Movimento findByConta(Conta conta);

    Movimento findByContaIdAndMovimentotipo(Long id, MovimentoTipo tipo);
}
