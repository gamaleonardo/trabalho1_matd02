/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.dcc.dao;

import br.ufba.dcc.jdbc.ConectionFactory;
import br.ufba.dcc.model.Relacao;
import br.ufba.dcc.model.Dispositivo;
import br.ufba.dcc.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class RelacaoDAO {
    private Connection con;
	
    public RelacaoDAO(){
	con = ConectionFactory.getPostgresConnection();
		
    }
    
    public void cadastrarRelacao(Relacao r){
		String sql = "INSERT INTO \"UserDevices\" (id_user,id_device) VALUES (?, ?)";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, r.getUsuario().getId());
			prep.setInt(2, r.getDispositivo().getID());
			System.out.println(prep.toString());
			prep.execute();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addDispositivo(Usuario usuario){
		String sql = "UPDATE \"UserDevices\" set login = ?, senha = ? WHERE login = ?";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, usuario.getLogin());
			prep.setString(2, usuario.getSenha());
			System.out.println(prep.toString());
			prep.execute();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletarRelacao(Relacao r){
		String sql = "DELETE FROM \"UserDevices\" WHERE id_user = ?";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, r.getUsuario().getId());
			System.out.println(prep.toString());
			prep.execute();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Dispositivo> listarDispositivos(Usuario u){
		String sql = "SELECT * FROM \"UserDevices\" WHERE id_user = ?";
		List<Dispositivo> list = null;
		try {
			PreparedStatement prep = con.prepareStatement(sql);
                        prep.setInt(1,u.getId());
			System.out.println(prep.toString());
			ResultSet res = prep.executeQuery();
			list = new ArrayList<Dispositivo>();
			while(res.next()){
				Dispositivo temp = new Dispositivo();
				temp.setID(res.getInt("id"));
				temp.setDescricao(res.getString("descricao"));
				list.add(temp);
			}
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Usuario> listarUsuarios(Dispositivo d){
		String sql = "SELECT * FROM \"UserDevices\" WHERE id_device = ?";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
                        prep.setInt(1,d.getID());
			System.out.println(prep.toString());
			ResultSet res = prep.executeQuery();
			List<Usuario> list = new ArrayList<Usuario>();
			while(res.next()){
				Usuario temp = new Usuario();
				temp.setId(res.getInt("id"));
				temp.setLogin(res.getString("login"));
				list.add(temp);
			}
			prep.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
