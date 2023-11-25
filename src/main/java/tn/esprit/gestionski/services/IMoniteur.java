package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;

import java.util.List;

public interface IMoniteur {
    public Moniteur addMoniteur(Moniteur m);
    public Moniteur uppdateMoniteur(Moniteur m);
    public List<Moniteur> findallMoniteur();
    public void delateCMoniteur(long numMoniteur);
    public Moniteur findbynum(long numMoniteur);
    public  Moniteur addmoniteurandassignetocours(Moniteur m,long numcours);
}
