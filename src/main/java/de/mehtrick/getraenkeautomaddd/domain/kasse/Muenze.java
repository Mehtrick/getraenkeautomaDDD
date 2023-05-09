package de.mehtrick.getraenkeautomaddd.domain.kasse;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Embeddable
@Getter
public class Muenze {

    @Enumerated(EnumType.STRING)
    private MuenzTyp typ;
}
