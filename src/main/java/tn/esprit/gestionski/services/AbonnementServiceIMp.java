package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.Repositories.AbonnementRepository;
import tn.esprit.gestionski.Repositories.SkieurRepository;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AbonnementServiceIMp implements IAbonnement{
    public AbonnementRepository abonnementRepository;
    public SkieurRepository skieurRepository;
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

    @Override
    public float sumduprix(LocalDate date) {
        return abonnementRepository.sumduprix(date);
    }
    @Scheduled(cron = "0 0 0 1 * *")
    public void showMonthlyRecurringRevenue() {
        log.info("Scheduled method is running...");
        LocalDate date = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        float sumprix=this.sumduprix(date);
        log.info(String.valueOf(sumprix));
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void retrieveExpiringSubscriptions() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date endDate = calendar.getTime();

        List<Abonnement> expiringSubscriptions = abonnementRepository.findExpiringSubscriptions(endDate);

        for (Abonnement abonnement: expiringSubscriptions) {
            Skieur skieur = skieurRepository.findByAbonnement(abonnement);

            log.info("Numéro de l'abonnement :"+abonnement.getNumAbon() +
                    "Informations sur le skieur"+skieur.getNumSkieur() +','+
                    skieur.getNomS() +','+skieur.getPrenoms());
        }
    }

}
