package tn.esprit.gestionski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;

public interface AbonnementRepository  extends JpaRepository<Abonnement,Long> {
    @Query("select a from Abonnement a where a.typeAbon =:type order by a.dateDebut")
    List<Abonnement> getAbonnementByTypeAbon(@Param("type") TypeAbonnement typeAbonnement);

    List<Abonnement> findByDateDebutBetween(Date date1,Date date2);
}
