package de.mehtrick.getraenkeautomaddd.domain;

import de.mehtrick.getraenkeautomaddd.domain.getraenke.GetraenkeBestand;
import de.mehtrick.getraenkeautomaddd.domain.getraenke.GetraenkeTyp;
import de.mehtrick.getraenkeautomaddd.domain.kasse.Kasse;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "getraenke_automat")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class GetraenkeAutomat extends AbstractEntity{

    @OneToOne(mappedBy = "automat",cascade = CascadeType.ALL)
    private GetraenkeBestand bestand;

    @OneToOne(mappedBy = "automat",cascade = CascadeType.ALL)
    private Kasse kasse;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="getraenkeauswahl",referencedColumnName = "id")
    private List<GetraenkeTyp> getraenkeAuswahl = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "getraenkewunsch")
    private GetraenkeTyp getraenkeWunsch;

    @PrePersist
    void init() {
        bestand = new GetraenkeBestand();
        kasse = new Kasse();
    }

}
