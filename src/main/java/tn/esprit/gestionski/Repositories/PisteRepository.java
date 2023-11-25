package tn.esprit.gestionski.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionski.entities.Piste;

public interface PisteRepository extends JpaRepository<Piste,Long> {
}
