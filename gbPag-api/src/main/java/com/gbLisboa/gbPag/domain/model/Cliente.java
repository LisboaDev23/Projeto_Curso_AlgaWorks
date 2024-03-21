package com.gbLisboa.gbPag.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "tb_cliente")
public class Cliente {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;
    //@Column(name = "nome", nullable = false)
    private String nome;
    //@Column(name = "email")
    private String email;
    @Column(name = "fone")
    private String telefone;

}
