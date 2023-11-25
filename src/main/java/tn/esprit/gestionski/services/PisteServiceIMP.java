package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.Repositories.PisteRepository;
import tn.esprit.gestionski.entities.Piste;

import java.util.List;

@Service
@AllArgsConstructor
public class PisteServiceIMP implements Ipiste{
    public PisteRepository pisteRepository;
    @Override
    public Piste addPiste(Piste c) {
        return pisteRepository.save(c);
    }

    @Override
    public Piste uppdatePiste(Piste c) {
        return pisteRepository.save(c);
    }

    @Override
    public List<Piste> findallPiste() {
        return pisteRepository.findAll();
    }

    @Override
    public void delatePiste(long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public Piste findbynum(long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }
}
