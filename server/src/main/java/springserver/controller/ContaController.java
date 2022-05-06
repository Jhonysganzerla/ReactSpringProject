package springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springserver.model.Conta;
import springserver.repository.ContaRepository;
import springserver.service.ContaService;
import springserver.service.GenericCrudService;
import springserver.service.MovimentoService;

@RestController
@RequestMapping("conta")
public class ContaController extends GenericCrudController<Conta, Long> {

    @Autowired
    ContaService contaService;

    @Override
    protected GenericCrudService<Conta, Long> getService() {
        return contaService;
    }
}
