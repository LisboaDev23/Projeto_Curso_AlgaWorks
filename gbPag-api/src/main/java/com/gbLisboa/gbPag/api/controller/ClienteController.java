package com.gbLisboa.gbPag.api.controller;

import com.gbLisboa.gbPag.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Gabriel Lisboa");
        cliente1.setEmail("gabriel.lisboadv@gmail.com");
        cliente1.setTelefone("85998523779");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Gabriel Coelho");
        cliente2.setEmail("gabriel.coelho@gmail.com");
        cliente2.setTelefone("85988547894");

        return Arrays.asList(cliente1,cliente2);
    }
}
