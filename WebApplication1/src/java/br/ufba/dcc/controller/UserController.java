/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.dcc.controller;

import br.ufba.dcc.service.UserServiceDAO_Service;
import br.ufba.dcc.service.Usuario;
import javax.xml.ws.WebServiceRef;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo
 */
@WebServlet("/usuario.do")
public class UserController extends HttpServlet{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/home_8080/UserServiceDAO/UserServiceDAO.wsdl")
    private UserServiceDAO_Service service;
    
    private static final long serialVersionUID = 1L;
    
    public UserController(){
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Façam a Listagem para a proxima aula. Quaquer dúvida, mandar Email para 
        // notlian.junior@gmail.com

        request.getRequestDispatcher("edituser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usu = new Usuario();
        usu.setLogin(request.getParameter("login"));
        usu.setSenha(request.getParameter("senha"));
        // Basta colocar objeto usuario dentro do new javax.xml.ws.Holder<Usuario>(usu)
        addUser(new javax.xml.ws.Holder<Usuario>(usu));
        response.sendRedirect("adduser.html");
    }

    private void addUser(javax.xml.ws.Holder<br.ufba.dcc.service.Usuario> u) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        br.ufba.dcc.service.UserServiceDAO port = service.getUserServiceDAOPort();
        port.addUser(u);
    }

   
    

    
}
