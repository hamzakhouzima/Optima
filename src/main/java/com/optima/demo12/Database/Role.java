package com.optima.demo12.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
@Column(name="Role")
private String Role;
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setRole(String role ){
        this.Role = role;
    }




}
