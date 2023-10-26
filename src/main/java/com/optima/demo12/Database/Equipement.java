package com.optima.demo12.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "equipement")
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "type")
    private String type;
    @Column(name = "buying_date")
    private String buying_date;

    @Column(name = "maintenance_date")
    private String maintenance_date;
    @Column(name = "state")
    private String state;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter methods for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter methods for buying_date
    public String getBuying_date() {
        return buying_date;
    }

    public void setBuying_date(String buying_date) {
        this.buying_date = buying_date;
    }

    // Getter and Setter methods for maintenance_date
    public String getMaintenance_date() {
        return maintenance_date;
    }

    public void setMaintenance_date(String maintenance_date) {
        this.maintenance_date = maintenance_date;
    }

    // Getter and Setter methods for state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
