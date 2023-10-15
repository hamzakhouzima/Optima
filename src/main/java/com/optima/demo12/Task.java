package com.optima.demo12;

import jakarta.persistence.*;



@Entity
@Table(name = "task")
public class Task {
    //Département : Attributs : id, nom, description, chef de département, etc.


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "deadline")
    private String deadline;

    @Column(name = "employee")
    private String employee;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee assignedTo;
}
