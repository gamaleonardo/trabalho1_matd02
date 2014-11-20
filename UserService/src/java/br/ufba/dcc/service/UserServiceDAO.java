/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.dcc.service;

import br.ufba.dcc.dao.UsuarioDAO;
import br.ufba.dcc.model.Usuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author guest-7JdAKi
 */
@WebService(serviceName = "UserServiceDAO")
@Stateless()
public class UserServiceDAO {

    /**
     * This is a sample web service operation
     * @return String
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + "!";
    }
    
    /**
     * This is a sample web service operation
     * @return list
     */
    @WebMethod(operationName = "listuser")
    public List<Usuario> listuser() {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> list = dao.listarUsuarios();
        
        return list;
    }
    
    /**
     * This is a sample web service operation
     * @param novo
     */
    @WebMethod(operationName = "addUser")
    public void addUser(@WebParam(name = "name") Usuario novo) {
        Usuario usu = new Usuario();
	usu.setNome(novo.getNome());
	usu.setLogin(novo.getLogin());
	usu.setSenha(novo.getSenha());
	UsuarioDAO dao = new UsuarioDAO();
	dao.cadastrarUsuario(usu);
        
    }
}
