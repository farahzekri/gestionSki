package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.Repositories.CoursRepository;
import tn.esprit.gestionski.Repositories.InscriptionRepository;
import tn.esprit.gestionski.Repositories.SkieurRepository;
import tn.esprit.gestionski.entities.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

@Service
@Slf4j
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

         LocalDate skieurBirthDate = new java.sql.Date(skieur.getDatenaissance().getTime()).toLocalDate();
        int skieurAge = Period.between(skieurBirthDate, LocalDate.now()).getYears();
        if(this.getnombredeskieur(numCours)>6 && cours.getTypecours()==Typecours.PARTICULOER){
           log.info("methode whith fixed rate");
        }
        else {

            if(((skieurAge>15) && (cours.getTypecours()==Typecours.COLLECTION_ADULTE))||((skieurAge <15) &&
                    (cours.getTypecours()==Typecours.COLLECTIOTION_ENFANT))){
                inscription.setSkieur(skieur);
                inscription.setCours(cours);
                return inscriptionRepository.save(inscription);
            }


            }

        return null;
    }


    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(long numMoniteur, Support support) {
        return inscriptionRepository.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
    }

    @Override
    public long getnombredeskieur(long numCours) {
        return inscriptionRepository.countSkiersByCourse(numCours);
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
