package com.gbLisboa.gbPag.api.controller;

import com.gbLisboa.gbPag.domain.exception.NegocioException;
import com.gbLisboa.gbPag.domain.model.Cliente;
import com.gbLisboa.gbPag.domain.repository.ClienteRepository;
import com.gbLisboa.gbPag.domain.service.CadastroClienteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CadastroClienteService cadastroClienteService;
    //@Autowired //deixamos de utilizar a anotação para usarmos o construtor, pois para cada instância de uma classe controladora, precisaremos de uma instância fornecida do Repository
    private  ClienteRepository clienteRepository;//final para dizer que depois de atribuída,ela não poderá ser mais alterada
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
    //        return manager.createQuery("from Cliente", Cliente.class)
//               .getResultList();
    //não é recomendado utilizarmos esse tipo de código utilizando jakarta, é necessário
    //mantermos uma arquitetura separando as responsabilidades, sem utilizar esse código
    //onde ele não irá conseguir se manter

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar (@PathVariable Long clienteId){
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){
        return cadastroClienteService.salvar(cliente);
    }
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
                                             @Valid @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = cadastroClienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluir (@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturarException(NegocioException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
