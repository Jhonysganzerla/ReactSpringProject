package springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springserver.service.ContaService;

@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    ContaService contaService;

}
