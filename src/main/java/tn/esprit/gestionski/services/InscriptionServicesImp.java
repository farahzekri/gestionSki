package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.Repositories.CoursRepository;
import tn.esprit.gestionski.Repositories.InscriptionRepository;
import tn.esprit.gestionski.Repositories.SkieurRepository;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

@Service
@AllArgsConstructor
public class InscriptionServicesImp implements IInscription {
    private InscriptionRepository inscriptionRepository;
    private SkieurRepository skieurRepository;
    private CoursRepository coursRepository;

    @Override
    public Inscription addSInscriptionandAssignetoskieur(Inscription n, long  numSkieur) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
        n.setSkieur(skieur);//définir le skieur associé à une inscription donnée.
        return inscriptionRepository.save(n);
    }


    @Override
    public Inscription addInscriptionandassignetocours(Inscription n, long numCours) {
        Cours cours=coursRepository.findById(numCours).orElse(null);
        n.setCours(cours);
        return inscriptionRepository.save(n);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, long numSkieur, long numCours) {
        Cours cours=coursRepository.findById(numCours).orElse(null);
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);

        return null;
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(long numMoniteur, Support support) {
        return inscriptionRepository.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
    }

    @Override
    public Inscription addinscription(Inscription n){
        return inscriptionRepository.save(n);
    }
    @Override
    public Inscription uppdateinscription(Inscription n) {
        return inscriptionRepository.save(n);
    }

    @Override
    public List<Inscription> findallInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public void delate(long numInscription) {
        inscriptionRepository.deleteById(numInscription);

    }

    @Override
    public Inscription findbynum(long numInscription) {
        return inscriptionRepository.findById(numInscription).orElse(null);
    }


}
