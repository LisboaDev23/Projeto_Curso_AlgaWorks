package com.gbLisboa.gbPag.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank //não pode ser nula, não pode ter espaço vazio e não pode ser uma string vazia
    @Size(max = 60)
    private String nome;
    //@Column(name = "email")
    @NotBlank
    @Size(max = 255)
    @Email
    private String email;
    @NotBlank
    @Size(max = 20)
    @Column(name = "fone")
    private String telefone;

}
