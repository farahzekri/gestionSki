package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.Iskieur;

import java.util.List;

@RestController
@AllArgsConstructor
public class skieurcontollers {
    private Iskieur iskieur;
     @PostMapping("/assignToPiste/{numPiste}/{numSkieur}")
    public Skieur assignSkieurToPiste(@PathVariable long numSkieur,@PathVariable long numPiste){
        return iskieur.assignSkieurToPiste(numSkieur,numPiste);
    }
    @PostMapping("/addskieur")
    public Skieur addskieur(@RequestBody Skieur S){
        return  iskieur.addSkieur(S);
    }
    @PutMapping("/uppdateSkieur")
    public Skieur uppdateSkieur(@RequestBody Skieur S){
        return iskieur.uppdateSkieur(S);
    }
    @GetMapping("/getall")
    public List<Skieur> findallSkieur(){
        return iskieur.findallSkieur();
    }
    @GetMapping("/get/{numSkieur}")
    public  Skieur findbynum(@PathVariable long numSkieur){
        return iskieur.findbynum(numSkieur);
    }
    public  void delate(@RequestBody Skieur S){
          iskieur.delate(S);
    }
    @PostMapping("/addSkieurandAssigntocours/{numcours}")
    public Skieur addSkieurandAssigntocours(@RequestBody Skieur skieur,@PathVariable long numcours){
         return iskieur.addSkieurandAssigntocours(skieur,numcours);
    }
    @GetMapping("/retrievetypeabonne/{type}")
    public List<Skieur> retrievetypeabonne(@PathVariable TypeAbonnement type){
         return iskieur.retriveSkieurByTypeabonnement(type);
    }
}
