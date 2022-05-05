package springserver.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springserver.model.Conta;
import springserver.repository.ContaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService implements GenericCrudService<Conta, Long> {

    ContaRepository contaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Conta> findAll() {
       return contaRepository.findAll();
    }

    @Override
    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Conta> findOne(Long id) {
        return contaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        contaRepository.deleteById(id);
    }
}
