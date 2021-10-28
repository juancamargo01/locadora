package com.juancamargo.locadora.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TBL_FILME")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FILMES")
    private  Long id ;

    @Column(name = "NOME_DO_DILME")
    @Size(min = 2, max = 255, message = "Deve conter entre 2 e 255 caracteres")

    private String nomeDoFilme;

    @Column(name = "FILME_DATA_LANCAMENTO")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataLancamento;

    @Column(name = "NOTA_USUARIO")
    private Double notaDosUsuarios;

    @Column(name = "NOTA_CRITICA")
    private Double notaDaCritica;

    @Column(name = "ESTA_LOCADO")
    private Boolean estaLocado;


    @Column(name = "ATORES")
    @OneToMany
    @JoinColumn(name = "TBL_FILME")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private List<Ator> ator;

}
