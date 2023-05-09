package de.mehtrick.getraenkeautomaddd.facade;

import de.mehtrick.getraenkeautomaddd.AbstractIntegrationTest;
import de.mehtrick.getraenkeautomaddd.domain.getraenke.GetraenkeTyp;
import de.mehtrick.getraenkeautomaddd.domain.kasse.Muenze;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static de.mehtrick.getraenkeautomaddd.domain.kasse.MuenzTyp.EIN_EURO;

class KundenInterfaceTest extends AbstractIntegrationTest {

    @Autowired
    private KundenInterface kundenInterface;

    @Autowired
    private WartungInterface wartungInterface;

    Long automatReferenz;

    @BeforeEach
    public void before() {
        automatReferenz = wartungInterface.erzeugeAutomat();
        wartungInterface.erzeugeGetraenkeTyp(automatReferenz, GetraenkeTyp.builder().name("Cola").preis(100).build());
    }

    @Test
    @Transactional
    void waehleGetraenk() {
        var getraenkeAutomat = getraenkeAutomatRepository.findById(automatReferenz);
        Assertions.assertThat(getraenkeAutomat.get().getGetraenkeWunsch()).isNull();

        var getraenketypen = kundenInterface.getGetraenkeAuswahl(automatReferenz);
        kundenInterface.waehleGetraenk(automatReferenz, getraenketypen.get(0));

        getraenkeAutomat = getraenkeAutomatRepository.findById(automatReferenz);
        Assertions.assertThat(getraenkeAutomat.get().getGetraenkeWunsch().getName()).isEqualTo(getraenketypen.get(0).getName());
    }

    @Test
    @Transactional
    void wirfMuenzeEin() {
        var getraenkeAutomat = getraenkeAutomatRepository.findById(automatReferenz);
        Assertions.assertThat(getraenkeAutomat.get().getEingeworfeneMuenzen()).hasSize(0);

        kundenInterface.wirfMuenzeEin(automatReferenz, Muenze.vomTyp(EIN_EURO));
        kundenInterface.wirfMuenzeEin(automatReferenz, Muenze.vomTyp(EIN_EURO));
        kundenInterface.wirfMuenzeEin(automatReferenz, Muenze.vomTyp(EIN_EURO));
        kundenInterface.wirfMuenzeEin(automatReferenz, Muenze.vomTyp(EIN_EURO));

        getraenkeAutomat = getraenkeAutomatRepository.findById(automatReferenz);
        Assertions.assertThat(getraenkeAutomat.get().getEingeworfeneMuenzen()).hasSize(4);
    }

    @Test
    void getGetraenkeAuswahl() {
        Assertions.assertThat(kundenInterface.getGetraenkeAuswahl(automatReferenz)).hasSize(1);
        wartungInterface.erzeugeGetraenkeTyp(automatReferenz, GetraenkeTyp.builder().name("Fanta").preis(100).build());
        Assertions.assertThat(kundenInterface.getGetraenkeAuswahl(automatReferenz)).hasSize(2);
    }
}