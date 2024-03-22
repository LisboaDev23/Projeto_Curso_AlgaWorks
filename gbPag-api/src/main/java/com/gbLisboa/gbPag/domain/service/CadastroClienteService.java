package com.gbLisboa.gbPag.domain.service;

import com.gbLisboa.gbPag.domain.exception.NegocioException;
import com.gbLisboa.gbPag.domain.model.Cliente;
import com.gbLisboa.gbPag.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastroClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente buscar (Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado!"));
    }
    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .filter(c ->!c.equals(cliente))
                .isPresent();
        if (emailEmUso){
            throw new NegocioException("Já existe um email cadastrado com esse e-mail.");
        }

        return clienteRepository.save(cliente);
    }
}
