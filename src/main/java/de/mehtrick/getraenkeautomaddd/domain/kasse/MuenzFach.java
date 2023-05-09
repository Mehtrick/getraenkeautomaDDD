package de.mehtrick.getraenkeautomaddd.domain.kasse;

import de.mehtrick.getraenkeautomaddd.domain.AbstractEntity;
import de.mehtrick.getraenkeautomaddd.domain.GetraenkeAutomat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Entity
@Table(name = "muenz_fach")
@Getter
@Setter
public class MuenzFach extends AbstractEntity {

    @ElementCollection(targetClass = Muenze.class)
    @JoinTable(name = "muenz_fach_muenze")
    @JoinColumn(name = "fach", referencedColumnName = "muenze")
    private List<Muenze> muenzen = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MuenzTyp typ;

    void fuegeMuenzeHinzu(Muenze muenze) {
        muenzen.add(muenze);
    }

    void entnehmeMuenze() {
        muenzen.remove(0);
    }
}
