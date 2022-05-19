package springserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springserver.model.Conta;
import springserver.model.User;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
