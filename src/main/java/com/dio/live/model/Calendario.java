package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited

public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private TipoData tipoData;
    private String descricao;
    private LocalDateTime dataEspecial;
}
