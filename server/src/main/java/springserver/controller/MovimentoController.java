package springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springserver.model.Movimento;
import springserver.model.User;
import springserver.service.ContaService;

@RestController
@RequestMapping("movimento")
public class MovimentoController extends GenericCrudController<Movimento,Long> {

    @Autowired
    ContaService movimentoService;

}
