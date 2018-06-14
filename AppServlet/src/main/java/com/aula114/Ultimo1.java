package com.aula114;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aula114.DAOPersImplRedis;

public class Ultimo1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
             doPost(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        DAOPers daopers = new DAOPersImplRedis();
        String path=request.getContextPath();
        String action=request.getRequestURI().substring(path.length());
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String correo=request.getParameter("correo");
        if(action.equals("/add")) {
          Persona persona= new Persona(nombre,apellido,correo);
      		daopers.insert(persona);
      		request.setAttribute("persona",persona);
      		request.getServletContext().getRequestDispatcher("/mi.jsp").forward(request,response);
          }
        }
        if(action.equals("/findAll")) {
          List<Persona> listpers = new ArrayList<Persona>();
          listpers = daopers.findAllPersonas();
          request.setAttribute("listpers",listpers);
          request.getRequestDispatcher("/mostrar.jsp").forward(request,response);
        }
      }
}
