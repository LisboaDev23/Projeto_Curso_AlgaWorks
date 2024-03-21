package com.gbLisboa.gbPag.api.controller;

import com.gbLisboa.gbPag.domain.model.Cliente;
import com.gbLisboa.gbPag.domain.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@AllArgsConstructor
@RestController
public class ClienteController {
//    @Autowired deixamos de utilizar a anotação para usarmos o construtor, pois para cada instância de uma classe controladora, precisaremos de uma instância fornecida do Repository
    private final ClienteRepository clienteRepository;//final para dizer que depois de atribuída,ela não poderá ser mais alterada
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return clienteRepository.findByNome("Gabriel Lisboa");
//        return manager.createQuery("from Cliente", Cliente.class)
//               .getResultList();
        //não é recomendado utilizarmos esse tipo de código utilizando jakarta, é necessário
        //mantermos uma arquitetura separando as responsabilidades, sem utilizar esse código
        //onde ele não irá conseguir se manter
    }
}
