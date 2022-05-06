package springserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springserver.model.Conta;
import springserver.repository.ContaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService extends GenericCrudServiceImpl<Conta, Long> {

    ContaRepository contaRepository;

    @Override
    protected JpaRepository<Conta, Long> getRepository() {
        return contaRepository;
    }

}
