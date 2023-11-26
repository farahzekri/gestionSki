package tn.esprit.gestionski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
    @Query("select e.numSemain from Inscription e " +
            "join Moniteur m " +
             "on e.cours member of m.Cours " +
            "where m.numMoniteur =:idMoniteur and e.cours.support =:supportcours ")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("idMoniteur") Long numMoniteur,@Param("supportcours") Support support);

    @Query("SELECT COUNT(i) FROM Inscription i " +
            "WHERE i.cours.numCours = :numCours " +
            "AND (i.cours.typecours = tn.esprit.gestionski.entities.Typecours.COLLECTIOTION_ENFANT " +
            "OR i.cours.typecours = tn.esprit.gestionski.entities.Typecours.COLLECTION_ADULTE)")

    long countSkiersByCourse(@Param("numCours") long numCours);
}
