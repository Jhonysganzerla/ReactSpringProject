package springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<T> getAll() {
        return genericCrudService.findAll();
    }

    @GetMapping("{id}")
    public Optional<T> findOne(@PathVariable ID id) {
        return genericCrudService.findOne(id);
    }

    @PostMapping
    public T save(@Valid @RequestBody T t) {
        return genericCrudService.save(t);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ID id) {
        genericCrudService.delete(id);
    }


}
