package de.mehtrick.getraenkeautomaddd.facade;

import de.mehtrick.getraenkeautomaddd.domain.getraenke.GetraenkeTyp;
import de.mehtrick.getraenkeautomaddd.domain.kasse.Muenze;

import java.util.List;

public interface KundenInterface {

    void waehleGetraenk(long automat, GetraenkeTyp getraenkeTyp);
    void wirfMuenzeEin(Muenze muenze);

    List<GetraenkeTyp> getGetraenkeAuswahl(Long automat);



}
