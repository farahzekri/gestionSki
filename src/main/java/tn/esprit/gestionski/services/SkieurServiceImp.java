package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.gestionski.Repositories.CoursRepository;
import tn.esprit.gestionski.Repositories.InscriptionRepository;
import tn.esprit.gestionski.Repositories.PisteRepository;
import tn.esprit.gestionski.Repositories.SkieurRepository;
import tn.esprit.gestionski.entities.*;

import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class SkieurServiceImp implements Iskieur{

    private SkieurRepository skieurRepository;
    private PisteRepository pisteRepository;
    private CoursRepository coursRepository;
    private InscriptionRepository inscriptionRepository;

    public Skieur assignSkieurToPiste(long numSkieur,long numPiste){
        Piste piste=pisteRepository.findById(numPiste).orElse(null);
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
       List<Piste>LP= skieur.getPistes();// Récupération de la liste des pistes mt3a skieur
              LP.add(piste);// Ajout de la piste à la liste des pistes du skieur
        skieur.setPistes(LP);// Mise à jour de la liste des pistes associées au skieur
         pisteRepository.save(piste);
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur addSkieurandAssigntocours(Skieur skieur, long numcours) {
        Skieur savedSkieur=skieurRepository.save(skieur);
        Cours cours=coursRepository.findById(numcours).orElse(null);
        List<Inscription> inscriptions=savedSkieur.getInscriptionList();
        for(Inscription i: inscriptions){
            i.setSkieur(savedSkieur);
            i.setCours(cours);
            inscriptionRepository.save(i);

        }

        return skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> retriveSkieurByTypeabonnement(TypeAbonnement type) {
        return skieurRepository.findByAbonnement_TypeAbon(type);
    }

    @Override
    public Skieur addSkieur(Skieur S) {
        return skieurRepository.save(S);
    }

    @Override
    public Skieur uppdateSkieur(Skieur S) {
        return skieurRepository.save(S);
    }

    @Override
    public List<Skieur> findallSkieur() {
        return skieurRepository.findAll();
    }

    @Override
    public void delate(Skieur S) {
        skieurRepository.delete(S);

    }

    @Override
    public Skieur findbynum(long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }
    @Scheduled(fixedRate = 30000)
    public void fixedRate(){
        log.info("methode whith fixed rate");
    }
    @Scheduled(cron = "0 33 16 * * *")
    public void cronemethode(){
        log.info("methode whith crone");
    }
}
