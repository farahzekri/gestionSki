package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.Repositories.CoursRepository;
import tn.esprit.gestionski.Repositories.MoniteurRepository;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MoniteurServiceIMP implements IMoniteur{
    public MoniteurRepository moniteurRepository;
    public CoursRepository coursRepository;
    @Override
    public Moniteur addMoniteur(Moniteur m) {
        return moniteurRepository.save(m);
    }

    @Override
    public Moniteur uppdateMoniteur(Moniteur m) {
        return moniteurRepository.save(m);
    }

    @Override
    public List<Moniteur> findallMoniteur() {
        return moniteurRepository.findAll();
    }

    @Override
    public void delateCMoniteur(long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);

    }

    @Override
    public Moniteur findbynum(long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public Moniteur addmoniteurandassignetocours(Moniteur m, long numcours) {
        Cours cours=coursRepository.findById(numcours).orElse(null);
        List<Cours> coursList=new ArrayList<>();
        coursList.add(cours);
        m.setCours(coursList);
        return moniteurRepository.save(m);
    }
}
