package tn.esprit.gestionski.services;



import tn.esprit.gestionski.entities.Piste;

import java.util.List;

public interface Ipiste {
    public Piste addPiste(Piste c);
    public Piste uppdatePiste(Piste c);
    public List<Piste> findallPiste();
    public void delatePiste(long numPiste);
    public Piste findbynum(long numPiste);
}
