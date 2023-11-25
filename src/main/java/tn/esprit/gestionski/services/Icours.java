package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

public interface Icours {
    public Cours addcours(Cours c);
    public Cours uppdatecours(Cours c);
    public List<Cours> findallcours();
    public void delateCours(long numCours);
    public Cours findbynum(long numCours);

}
