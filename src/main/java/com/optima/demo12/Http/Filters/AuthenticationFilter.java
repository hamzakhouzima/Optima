//package com.optima.demo12.Http.Filters;
//
//import com.optima.demo12.Database.Employee;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebFilter("/demo12_war_exploded/admin/")
//public class AuthenticationFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        // Check if the user is authenticated (e.g., based on session or other authentication mechanism)
//        HttpSession session = httpRequest.getSession(false); // Don't create a new session if it doesn't exist
//
//        if (httpRequest.getRequestURI().endsWith("/LoginServlet")) {
//            chain.doFilter(request, response);
//        } else if (session == null || session.getAttribute("id") == null) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/LoginServlet");
//
//
//
//
//        } else {
//            // User is authenticated, allow the request to continue
////            Employee employee = new Employee();
////            session.setAttribute("id", employee.getId());
//
//            chain.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//
////
//
//    // Implement init() and destroy() methods as required by the Filter interface
//}
////if(name.equals("reda")) {
////    RequestDispatcher requestDispatcher=request.getRequestDispatcher("Profile");
////    requestDispatcher.forward(request, response);
////}