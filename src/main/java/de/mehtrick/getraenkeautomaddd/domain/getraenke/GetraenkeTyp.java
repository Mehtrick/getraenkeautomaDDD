package de.mehtrick.getraenkeautomaddd.domain.getraenke;


import de.mehtrick.getraenkeautomaddd.domain.AbstractEntity;
import de.mehtrick.getraenkeautomaddd.domain.GetraenkeAutomat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "getraenke_typ")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class GetraenkeTyp extends AbstractEntity {

    @Column(nullable = false)
    private int preis;

    @Column(nullable = false, updatable = false)
    private String name;


}
