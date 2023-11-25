package tn.esprit.gestionski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {

    List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);

    //@Query("select s.numSkieur from Skieur s"+
          //  " join Cours c  "+
           // " on s.inscriptionList member  c.inscriptionList"+
            //" where s.numSkieur =:numSkieur and c.numCours =: numCours "
   // )
     // List<Skieur> getSkieur(@Param("numSkieur") long numSkieur , @Param("numCours") long numCours);
}
