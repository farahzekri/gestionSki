package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.services.MoniteurServiceIMP;

import java.util.List;

@RestController
@AllArgsConstructor
public class MoniteurController {
    public MoniteurServiceIMP moniteurServiceIMP;
    @PostMapping("/addmoniteurandassignetocours/{numcours}")
    public  Moniteur addmoniteurandassignetocours(@RequestBody Moniteur m,@PathVariable long numcours){
        return moniteurServiceIMP.addmoniteurandassignetocours(m,numcours);
    }
   @PostMapping("/ajoutermoniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur m) {
        return moniteurServiceIMP.addMoniteur(m);
    }

    @PutMapping("/updatemoniteur")
    public Moniteur uppdateMoniteur(@RequestBody Moniteur m) {
        return moniteurServiceIMP.uppdateMoniteur(m);
    }

    @GetMapping("/getallmoniteur")
    public List<Moniteur> findallMoniteur() {
        return moniteurServiceIMP.findallMoniteur();
    }

    @DeleteMapping("/deletemoniteur/{numMoniteur}")
    public void delateCMoniteur(@PathVariable long numMoniteur) {
        moniteurServiceIMP.delateCMoniteur(numMoniteur);

    }

    @GetMapping("/getmoniteurbyid/{numMoniteur}")
    public Moniteur findbynum(@PathVariable long numMoniteur) {
        return moniteurServiceIMP.findbynum(numMoniteur);
    }
}
