package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.Repositories.CoursRepository;
import tn.esprit.gestionski.entities.Cours;

import java.util.List;
@Service
@AllArgsConstructor
public class CoursServicesImp implements Icours{
    public CoursRepository coursRepository;

    @Override
    public Cours addcours(Cours c) {
        return coursRepository.save(c);
    }

    @Override
    public Cours uppdatecours(Cours c) {
        return coursRepository.save(c);
    }

    @Override
    public List<Cours> findallcours() {
        return coursRepository.findAll();
    }

    @Override
    public void delateCours(long numCours) {
        coursRepository.deleteById(numCours);

    }

    @Override
    public Cours findbynum(long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }
}
