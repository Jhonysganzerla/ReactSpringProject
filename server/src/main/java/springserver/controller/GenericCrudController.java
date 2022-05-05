package springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import springserver.service.GenericCrudService;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
public class GenericCrudController<T,ID extends Serializable> {

    @Autowired
    private GenericCrudService<T,ID> genericCrudService;

    @GetMapping("/")
    public List<T> getAll() {
        return genericCrudService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<T> getById(ID id) {
        return genericCrudService.findOne(id);
    }

    @PostMapping("/save")
    public T save(@Valid @RequestBody T t) {
        return genericCrudService.save(t);
    }

    @DeleteMapping("/{id}")
    public void delete(ID id) {
        genericCrudService.delete(id);
    }


}
