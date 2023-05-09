package de.mehtrick.getraenkeautomaddd.domain.getraenke;

import de.mehtrick.getraenkeautomaddd.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Entity
@Table(name = "getraenke")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Getraenk extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "getraenk_typ_id")
    private GetraenkeTyp typ;

}
