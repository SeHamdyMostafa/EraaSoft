package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    private int id;

    private String userName;

    private double salary;

    @OneToOne
    @JoinColumn(name = "doctorDetails_id")
    private DoctorDetails doctorDetails;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

}