package springserver.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springserver.model.Conta;
import springserver.model.Movimento;
import springserver.repository.MovimentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentoService extends GenericCrudServiceImpl<Movimento,Long> {

    MovimentoRepository movimentoRepository;

    @Override
    protected JpaRepository<Movimento, Long> getRepository() {
        return movimentoRepository;
    }

}
