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

}
