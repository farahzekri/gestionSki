package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long numSkieur;
    private String nomS;
    private String prenoms;
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    private String ville;
    @ManyToMany
    private List<Piste> pistes;
    @OneToOne
    private Abonnement abonnement;
    @OneToMany(mappedBy = "skieur")
    private List<Inscription> inscriptionList;


}
