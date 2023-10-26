package com.optima.demo12.Http;

import com.optima.demo12.Database.Employee;
import com.optima.demo12.Database.Equipement;
import com.optima.demo12.Service.EmployeeService;
import com.optima.demo12.Service.ReservationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ReservationServlet", urlPatterns={"/demo12_war_exploded/admin/Reservation/"})
public class ReservationServlet extends HttpServlet {
    @PersistenceUnit(unitName = "default")
    private EntityManager entityManager;
    EmployeeService employeeList = new EmployeeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the login page (login.jsp)
        ReservationService reservationService = new ReservationService();

        List<Equipement> equipements = reservationService.fetchEquipementData();

        request.setAttribute("equipements", equipements);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmpPage.jsp");
        dispatcher.include(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve employee and equipment details from the request parameters
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int equipementId = Integer.parseInt(request.getParameter("equipementId"));

        // Create the EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        // Initialize the ReservationService
        ReservationService reservationService = new ReservationService();

        // Fetch the Employee and Equipement objects
        Employee employee = emf.createEntityManager().find(Employee.class, employeeId);
        Equipement equipement = emf.createEntityManager().find(Equipement.class, equipementId);

        // Make the reservation
        reservationService.MakeReservation(employee, equipement);

        // Redirect to a confirmation page or display a success message
//        response.sendRedirect(request.getContextPath() + "/reservation-confirmation.jsp");
    }

}
