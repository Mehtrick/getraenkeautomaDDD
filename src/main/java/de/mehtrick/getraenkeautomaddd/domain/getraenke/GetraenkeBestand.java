package de.mehtrick.getraenkeautomaddd.domain.getraenke;

import de.mehtrick.getraenkeautomaddd.domain.AbstractEntity;
import de.mehtrick.getraenkeautomaddd.domain.GetraenkeAutomat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Entity
@Table(name = "getraenke_bestand")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class GetraenkeBestand extends AbstractEntity {

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name="bestand",referencedColumnName = "id")
    private List<Getraenk> getraenke = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "automat_id")
    private GetraenkeAutomat automat;
}
