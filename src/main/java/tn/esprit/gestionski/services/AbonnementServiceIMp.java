package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.Repositories.AbonnementRepository;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementServiceIMp implements IAbonnement{
    public AbonnementRepository abonnementRepository;
    @Override
    public Abonnement addAbonnement(Abonnement a) {
        return abonnementRepository.save(a);
    }

    @Override
    public Abonnement uppdateAbonnement(Abonnement a) {
        return abonnementRepository.save(a);
    }

    @Override
    public List<Abonnement> findallAbonnement() {
        return abonnementRepository.findAll();
    }

    @Override
    public void delateAbonnement(long numAbon) {
        abonnementRepository.deleteById(numAbon);
    }

    @Override
    public Abonnement findbynum(long numAbon) {
        return abonnementRepository.findById(numAbon).orElse(null);
    }

    @Override
    public List<Abonnement> getAbonnementByTypeAbon(TypeAbonnement typeAbonnement) {
        return abonnementRepository.getAbonnementByTypeAbon(typeAbonnement);
    }

    @Override
    public List<Abonnement> getByDateDebutBetween(Date date1, Date date2) {
        return abonnementRepository.findByDateDebutBetween(date1,date2);
    }
}
