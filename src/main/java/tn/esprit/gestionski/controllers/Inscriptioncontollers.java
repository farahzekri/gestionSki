package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;
import tn.esprit.gestionski.services.IInscription;
import tn.esprit.gestionski.services.Iskieur;

import java.util.List;

@RestController
@AllArgsConstructor
public class Inscriptioncontollers {
    public IInscription iInscription;
    @PostMapping("/addendassignetskieur/{numSkieur}")
    public Inscription addSInscriptionandAssignetoskieur(@RequestBody Inscription n, @PathVariable long  numSkieur){
        return iInscription.addSInscriptionandAssignetoskieur(n,numSkieur);
    }
    @PostMapping("/addendassignetcours/{numCours}")
    public Inscription addInscriptionandassignetocours(@RequestBody Inscription n, @PathVariable long numCours){
        return iInscription.addInscriptionandassignetocours(n,numCours);
    }
    @PostMapping("/ajouterinscription")
    public Inscription addinscription(@RequestBody Inscription n){
        return iInscription.addinscription(n);
    }

    @PutMapping("/miseajour")
    public Inscription uppdateinscription(@RequestBody Inscription n) {
        return iInscription.uppdateinscription(n);
    }

  @GetMapping("/gettallinscription")
    public List<Inscription> findallInscription() {
        return iInscription.findallInscription();
    }

    @DeleteMapping("/deleteinscription/{numInscription}")
    public void delate(@PathVariable long numInscription) {
        iInscription.delate(numInscription);

    }

  @GetMapping("/getbynum/{numInscription}")
    public Inscription findbynum(@PathVariable long numInscription) {
        return iInscription.findbynum(numInscription);
    }
   @GetMapping("/numWeeksCourseOfInstructorBySupport/{numMoniteur}/{support}")
    public List<Integer> numWeeksCourseOfInstructorBySupport(@PathVariable long numMoniteur, @PathVariable Support support){
        return iInscription.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
   }
    @GetMapping("/countSkiersByCourse/{numCours}")
    public long  getSkiersByCourse(@PathVariable long numCours){
        return iInscription.getnombredeskieur(numCours);
    }
    @PostMapping("/addinscriptiontoskieurandcours/{numSkieur}/{numCours}")
    public Inscription addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription, @PathVariable long numSkieur,@PathVariable long numCours){
        return iInscription.addRegistrationAndAssignToSkierAndCourse(inscription,numSkieur,numCours);
    }
}
