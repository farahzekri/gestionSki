package tn.esprit.gestionski.services;



import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;

public interface IAbonnement {
    public Abonnement addAbonnement(Abonnement a);
    public Abonnement uppdateAbonnement(Abonnement a);
    public List<Abonnement> findallAbonnement();
    public void delateAbonnement(long numAbon);
    public Abonnement findbynum(long numAbon);
    public List<Abonnement> getAbonnementByTypeAbon(TypeAbonnement typeAbonnement);
    public  List<Abonnement> getByDateDebutBetween(Date date1,Date date2);
}
