package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {

    @Id
    private int id;

    private String name;

    private String typeOfDisease;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToMany(mappedBy = "patients")
    private List<Hospital> hospitals;

}