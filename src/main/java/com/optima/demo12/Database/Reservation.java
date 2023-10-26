package com.optima.demo12.Database;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne  // Add this annotation for the equipement attribute
    @JoinColumn(name = "equipement_id")  // Define the column name for the equipement foreign key
    private Equipement equipement;  // Define an equipement attribute

    @Column(name = "reservation_date")
    private String reservation_date;

    @Column(name = "return_date")
    private String return_date;

    @Column(name = "type")
    private String type;

    // Getter and setter methods for the equipement attribute
    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getId() {
        return id;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public String getType() {
        return type;
    }



}
