package de.mehtrick.getraenkeautomaddd.facade;

import de.mehtrick.getraenkeautomaddd.domain.GetraenkeAutomat;
import de.mehtrick.getraenkeautomaddd.domain.getraenke.Getraenk;
import de.mehtrick.getraenkeautomaddd.domain.getraenke.GetraenkeTyp;
import de.mehtrick.getraenkeautomaddd.domain.kasse.Muenze;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
class AutomatService implements KundenInterface, WartungInterface {

    private final GetraenkeAutomatRepository getraenkeAutomatRepository;

    @Override
    public void waehleGetraenk(long automat, GetraenkeTyp getraenkeTyp) {
        var getraenkeAutomat = getraenkeAutomatRepository.findById(automat).orElseThrow();
        getraenkeAutomat.setGetraenkeWunsch(getraenkeTyp);
    }

    @Override
    public void wirfMuenzeEin(Muenze muenze) {

    }

    @Override
    public List<GetraenkeTyp> getGetraenkeAuswahl(Long automat) {
        return getraenkeAutomatRepository.findAllGetraenkeTypenByAutomat(automat);
    }

    @Override
    public void befuelleGetraenkeFach(Long automat, Getraenk getraenk) {

    }

    @Override
    public void befuelleMuenzFach(Long automat, Muenze muenze) {

    }

    @Override
    public void erzeugeGetraenkeTyp(Long automat, GetraenkeTyp getraenkeTyp) {
        var getraenkeAutomat = getraenkeAutomatRepository.findById(automat).orElseThrow();
        getraenkeAutomat.getGetraenkeAuswahl().add(getraenkeTyp);
        getraenkeAutomatRepository.save(getraenkeAutomat);
    }

    @Override
    public Long erzeugeAutomat() {
        var automat = new GetraenkeAutomat();
        return getraenkeAutomatRepository.save(automat).getId();
    }
}
