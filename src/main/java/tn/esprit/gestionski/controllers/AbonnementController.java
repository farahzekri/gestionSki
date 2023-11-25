package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.AbonnementServiceIMp;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class AbonnementController {
    public AbonnementServiceIMp abonnementServiceIMp;
    @PostMapping("/addabondem")
    public Abonnement addAbonnement(@RequestBody Abonnement a) {
        return abonnementServiceIMp.addAbonnement(a);
    }

    @PutMapping("uppdateabon")
    public Abonnement uppdateAbonnement(@RequestBody Abonnement a) {
        return abonnementServiceIMp.uppdateAbonnement(a);
    }

    @GetMapping("/findallabon")
    public List<Abonnement> findallAbonnement() {
        return abonnementServiceIMp.findallAbonnement();
    }

    @DeleteMapping("/deleteabond/{numAbon}")
    public void delateAbonnement(@PathVariable long numAbon) {
        abonnementServiceIMp.delateAbonnement(numAbon);
    }

    @GetMapping("/getabondbyid/{numAbon}")
    public Abonnement findbynum(@PathVariable long numAbon) {
        return abonnementServiceIMp.findbynum(numAbon);
    }
    @GetMapping("/getAbonnementByTypeAbon/{typeAbonnement}")
    public List<Abonnement> getAbonnementByTypeAbon(@PathVariable TypeAbonnement typeAbonnement){
        return abonnementServiceIMp.getAbonnementByTypeAbon(typeAbonnement);
    }
    @GetMapping("/findByDateDebutBetween/{date1}/{date2}")
    public List<Abonnement> getByDateDebutBetween(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date1,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date2){
        return abonnementServiceIMp.getByDateDebutBetween(date1,date2);
    }
}
