package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.List;

public interface Iskieur {

    public Skieur addSkieur(Skieur S);
    public Skieur uppdateSkieur(Skieur S);
    public List<Skieur> findallSkieur();
    public void delate(Skieur S);
    public Skieur findbynum(long numSkieur);
    public Skieur assignSkieurToPiste(long numSkieur, long numPiste);
    public Skieur addSkieurandAssigntocours(Skieur skieur,long numcours);
    public List<Skieur> retriveSkieurByTypeabonnement(TypeAbonnement type);
}
