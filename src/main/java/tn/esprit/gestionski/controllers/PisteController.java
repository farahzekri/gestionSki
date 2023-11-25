package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.services.PisteServiceIMP;

import java.util.List;
@RestController
@AllArgsConstructor
public class PisteController {
    public PisteServiceIMP pisteServiceIMP;
    @PostMapping("/addpiste")
    public Piste addPiste(@RequestBody Piste c) {
        return pisteServiceIMP.addPiste(c);
    }

    @PutMapping("/updatepiste")
    public Piste uppdatePiste(@RequestBody Piste c) {
        return pisteServiceIMP.uppdatePiste(c);
    }

    @GetMapping("/getallpistes")
    public List<Piste> findallPiste() {
        return pisteServiceIMP.findallPiste();
    }

   @DeleteMapping("/deletepistes/{numPiste}")
    public void delatePiste(long numPiste) {
       pisteServiceIMP.delatePiste(numPiste);
    }

    @GetMapping("getpistesbyid/{numPiste}")
    public Piste findbynum(long numPiste) {
        return pisteServiceIMP.findbynum(numPiste);
    }
}
