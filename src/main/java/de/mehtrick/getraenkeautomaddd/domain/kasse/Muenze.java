package de.mehtrick.getraenkeautomaddd.domain.kasse;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;

@Embeddable
@Getter
public class Muenze {

    @Enumerated(EnumType.STRING)
    private MuenzTyp typ;

    public static Muenze vomTyp(@NonNull MuenzTyp muenzTyp) {
        var muenze = new Muenze();
        muenze.typ = muenzTyp;
        return muenze;
    }
}
