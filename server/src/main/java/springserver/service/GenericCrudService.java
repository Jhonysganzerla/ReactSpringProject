package springserver.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public interface GenericCrudService<T, ID extends Serializable> {

    List<T> findAll();

    T save(T conta);

    Optional<T> findOne(ID id);

    void delete(ID id);
}
