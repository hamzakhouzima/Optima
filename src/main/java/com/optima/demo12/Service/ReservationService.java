package com.optima.demo12.Service;

//import com.optima.demo12.Database.Employee;

import com.optima.demo12.Database.Employee;
import com.optima.demo12.Database.Equipement;
import com.optima.demo12.Database.Reservation;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;


public class ReservationService implements ReservationInterface{
    @PersistenceContext(unitName = "default")
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();

    @Override
    public void MakeReservation(Employee employee, Equipement equipement) {
        try {
            entityManager.getTransaction().begin();

            // Create a new Reservation object
            Reservation reservation = new Reservation();
            reservation.setEmployee(employee);
            reservation.setEquipement(equipement);

            // Persist the Reservation object
            entityManager.persist(reservation);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public List<Equipement> fetchEquipementData() {
        String selectQuery = "SELECT e FROM Equipement e";
        TypedQuery<Equipement> query = entityManager.createQuery(selectQuery, Equipement.class);
        List<Equipement> equipements = query.getResultList();
        return equipements;
    }

}



















//
//    @PersistenceContext(unitName = "default")
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//    EntityManager entityManager = emf.createEntityManager();
//
//    @Transactional
//    public List<Reservation> dirLihKhatro() {
//        String selectQuery = "SELECT r FROM Reservation r WHERE r.type = 'jetable' AND r.date > current_date  "   ;
//        TypedQuery<Reservation> query = entityManager.createQuery(selectQuery, Reservation.class);
//        List<Reservation> reservations = query.getResultList();
//        //smiyto.length
//
//
//
//
//        return reservations;