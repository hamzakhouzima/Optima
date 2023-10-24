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

    @Column(name = "reservation_date")
    private String reservation_date;

    @Column(name = "return_date")
    private String return_date;

    @Column(name = "type")
    private String type;


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
