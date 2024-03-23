package com.gbLisboa.gbPag.domain.service;

import com.gbLisboa.gbPag.domain.exception.NegocioException;
import com.gbLisboa.gbPag.domain.model.Cliente;
import com.gbLisboa.gbPag.domain.model.Parcelamento;
import com.gbLisboa.gbPag.domain.repository.ParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class ParcelamentoService {

    private ParcelamentoRepository parcelamentoRepository;
    private CadastroClienteService cadastroClienteService;
    @Transactional
    public Parcelamento cadastrar(Parcelamento novoParcelamento){
        if (novoParcelamento.getId()!=null){
            throw new NegocioException("O parcelamento que for criado, não deverá ter um código existente!");
        }
        Cliente cliente = cadastroClienteService.buscar(novoParcelamento.getCliente().getId());
        novoParcelamento.setCliente(cliente);
        novoParcelamento.setDataCriacao(OffsetDateTime.now());
        novoParcelamento.setDataCriacao(OffsetDateTime.now());
        return parcelamentoRepository.save(novoParcelamento);
    }
}
