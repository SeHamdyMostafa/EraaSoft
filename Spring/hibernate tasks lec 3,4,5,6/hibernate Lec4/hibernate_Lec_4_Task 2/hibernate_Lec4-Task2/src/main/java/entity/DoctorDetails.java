package entity;

import javax.persistence.*;

@Entity
public class DoctorDetails {

    @Id
    private int id;

    private String fullAddress;

    private String firstName;

    private String lastName;

    private int age;

    @OneToOne(mappedBy = "doctorDetails")
    private Doctor doctor;

}