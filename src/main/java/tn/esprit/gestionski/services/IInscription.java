package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface IInscription {
    public Inscription addSInscriptionandAssignetoskieur(Inscription n, long  numSkieur);
    public Inscription addinscription(Inscription n);
    public Inscription uppdateinscription(Inscription n);
    public List<Inscription> findallInscription();
    public void delate(long numInscription);
    public Inscription findbynum(long numInscription);
    public Inscription addInscriptionandassignetocours(Inscription n,long numCours);
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, long numSkieur, long numCours);
    public List<Integer> numWeeksCourseOfInstructorBySupport(long numMoniteur, Support support);
}
