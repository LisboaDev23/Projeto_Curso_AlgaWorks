package com.gbLisboa.gbPag.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcelamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private String descricao;

    private BigDecimal valorTotal;

    private Integer quantidadeParcelas;

    private LocalDateTime dataCriacao;

}
