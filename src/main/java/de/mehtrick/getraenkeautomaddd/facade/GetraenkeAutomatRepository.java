package de.mehtrick.getraenkeautomaddd.facade;

import de.mehtrick.getraenkeautomaddd.domain.GetraenkeAutomat;
import de.mehtrick.getraenkeautomaddd.domain.getraenke.GetraenkeTyp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetraenkeAutomatRepository extends JpaRepository<GetraenkeAutomat, Long>{


    @Query("select g.getraenkeAuswahl from GetraenkeAutomat g where g.id = ?1")
    List<GetraenkeTyp> findAllGetraenkeTypenByAutomat(Long automat);

}
