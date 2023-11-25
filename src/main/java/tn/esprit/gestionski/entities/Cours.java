package tn.esprit.gestionski.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCours ;
    private int niveau;
    @Enumerated(EnumType.STRING)
    private Typecours typecours;
    @Enumerated(EnumType.STRING)
    private Support support;
    private float prix;
    private  int creneau;
    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscriptionList;
}
