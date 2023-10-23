package com.optima.demo12.Database;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date")
    private String date;

    @Column(name = "enabled", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean enabled ;

    @Column(name = "locked", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean locked ;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departement department;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "assignedTo")
    private List<Task> tasks;


//    public void setRoleFromString(int roleName) {
//
//            Role role = new Role();
//            role.setRole(roleName); // Assuming "Role" has a "name" property
//
//            this.role = role;
//
//    }

    public void setRoleId(String roleId) {
        Role role = new Role();
        role.setId(Integer.parseInt(roleId));
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Departement getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }


    public void setDepId(String depId) {
        Departement dep = new Departement();
        try {
            // Assuming depId is a String representing an integer
            int departmentId = Integer.parseInt(depId);
            dep.setId(departmentId);
            this.department = dep;
        } catch (NumberFormatException e) {
            // Handle the exception if depId is not a valid integer
            e.printStackTrace();
        }
    }




    public Role getRole() {
        return role;
    }

    public void setRole_id(Role role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public Boolean getEnabled(){
        return enabled;
    }
    public void setEnabled(Boolean enabled){
        this.enabled = enabled;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
