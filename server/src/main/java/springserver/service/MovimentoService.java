package springserver.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springserver.model.Movimento;
import springserver.repository.MovimentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentoService implements GenericCrudService<Movimento,Long> {

    MovimentoRepository movimentoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Movimento> findAll() {
        return movimentoRepository.findAll();
    }

    @Override
    public Movimento save(Movimento movimento) {
        return movimentoRepository.save(movimento);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Movimento> findOne(Long id) {
        return movimentoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        movimentoRepository.deleteById(id);
    }

}
