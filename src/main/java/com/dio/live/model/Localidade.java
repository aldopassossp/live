package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited

public class Localidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private NivelAcesso nivelAcesso;
    private String descricao;
}
