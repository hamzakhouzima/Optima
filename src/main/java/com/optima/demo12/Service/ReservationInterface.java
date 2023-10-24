package com.optima.demo12.Service;

import com.optima.demo12.Database.Employee;
import com.optima.demo12.Database.Equipement;

public interface ReservationInterface {

    //to make a reservation you should add the employee id to the reservation table , the reserved equipment , the reservation date and the return date

    void MakeReservation(Employee employee, Equipement equipement);



}
