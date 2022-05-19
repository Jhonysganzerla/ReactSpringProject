package springserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springserver.model.Conta;
import springserver.repository.ContaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService extends GenericCrudServiceImpl<Conta, Long> {

    @Autowired
    ContaRepository contaRepository;

    @Override
    protected JpaRepository<Conta, Long> getRepository() {
        return contaRepository;
    }


    @Override
    public List<Conta> findAll() {
        return super.findAll();
    }

    @Override
    public List<Conta> findAll(Sort sort) {
        return super.findAll(sort);
    }

    @Override
    public Page<Conta> findAll(Pageable pageable) {
        return super.findAll(pageable);
    }

    @Override
    public Conta findOne(Long aLong) {
        return super.findOne(aLong);
    }
}
