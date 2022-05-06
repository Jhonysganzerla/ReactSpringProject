package springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springserver.model.Movimento;
import springserver.service.GenericCrudService;
import springserver.service.MovimentoService;

@RestController
@RequestMapping("movimento")
public class MovimentoController extends GenericCrudController<Movimento,Long> {

    @Autowired
    MovimentoService movimentoService;

    @Override
    protected GenericCrudService<Movimento, Long> getService() {
        return movimentoService;    
    }
}
