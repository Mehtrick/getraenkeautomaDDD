package de.mehtrick.getraenkeautomaddd.facade;

import de.mehtrick.getraenkeautomaddd.domain.getraenke.Getraenk;
import de.mehtrick.getraenkeautomaddd.domain.getraenke.GetraenkeTyp;
import de.mehtrick.getraenkeautomaddd.domain.kasse.Muenze;

import java.util.List;

public interface WartungInterface {

    void befuelleGetraenkeFach(Long automat, Getraenk getraenk);
    void befuelleMuenzFach(Long automat,Muenze muenze);
    void erzeugeGetraenkeTyp(Long automat,GetraenkeTyp getraenkeTyp);

    Long erzeugeAutomat();

}
