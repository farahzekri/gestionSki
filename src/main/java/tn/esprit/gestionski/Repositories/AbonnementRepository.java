package tn.esprit.gestionski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AbonnementRepository  extends JpaRepository<Abonnement,Long> {
    @Query("select a from Abonnement a where a.typeAbon =:type order by a.dateDebut")
    List<Abonnement> getAbonnementByTypeAbon(@Param("type") TypeAbonnement typeAbonnement);

    List<Abonnement> findByDateDebutBetween(Date date1,Date date2);
    @Query("select sum(a.prixAbon) from Abonnement a" +
            " Where month (a.dateDebut)=month (:date)"+
            "and year (a.dateDebut)=year (:date)")
    float sumduprix(@Param("date") LocalDate date);

   @Query("SELECT a FROM Abonnement a WHERE a.datefin BETWEEN CURRENT_DATE AND :endDate")
    List<Abonnement> findExpiringSubscriptions(@Param("endDate") Date endDate);
}
