package springserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springserver.model.Conta;
import springserver.model.DTO.MovimentoByContasDTO;
import springserver.model.Movimento;
import springserver.model.User;
import springserver.model.enumerators.MovimentoTipo;

import java.util.List;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

    Movimento findByConta(Conta conta);

    Movimento findByContaIdAndMovimentotipo(Long id, MovimentoTipo tipo);

    Movimento findByIdAndContaUser(Long id, User user);

    List<Movimento> findAllByContaUser(User user);

    List<Movimento> findAllByContaUser(User user, Sort sort);

    Page<Movimento> findAllByContaUser(User user, Pageable pageable);
}
