package com.gbLisboa.gbPag.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Getter
@Setter
public class ParcelamentoModel {

    private Long id;

    private String nomeCliente;

    private String descricao;

    private Integer parcelas;

    private BigDecimal valorTotal;

    private OffsetDateTime dataCriacao;


}
