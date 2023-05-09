package de.mehtrick.getraenkeautomaddd.domain.kasse;

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
@Table(name = "kasse")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Kasse extends AbstractEntity {

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name="kasse",referencedColumnName = "id")
    private List<MuenzFach> muenzfaecher = new ArrayList<>();

    void sortiereMuenzeEin(Muenze muenze) {
        muenzfaecher
                .stream()
                .filter(muenzFach -> muenzFach.getTyp().equals(muenze.getTyp()))
                .findFirst()
                .orElseThrow()
                .fuegeMuenzeHinzu(muenze);
    }

    @OneToOne
    @JoinColumn(name = "automat_id")
    private GetraenkeAutomat automat;

    /**
     * Initialisiert die Münzfächer mit den entsprechenden Münztypen
     * @see MuenzTyp
     */
    @PrePersist
    void init() {
        for (MuenzTyp typ : MuenzTyp.values()) {
            MuenzFach fach = new MuenzFach();
            fach.setTyp(typ);
            muenzfaecher.add(fach);
        }
    }

}
