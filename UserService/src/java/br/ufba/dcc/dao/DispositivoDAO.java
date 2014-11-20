/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.dcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.dcc.jdbc.ConectionFactory;
import br.ufba.dcc.model.Dispositivo;

/**
 *
 * @author leonardo
 */
public class DispositivoDAO {
    private Connection con;
	
    public DispositivoDAO(){
	con = ConectionFactory.getPostgresConnection();
		
    }

    public void cadastrarDispositivo(Dispositivo d){
		String sql = "INSERT INTO \"Devices\" (id,descricao) VALUES (?, ?)";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, d.getID());
			prep.setString(2, d.getDescricao());
			System.out.println(prep.toString());
			prep.execute();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public void atualizarDispositivo(Dispositivo d){
	String sql = "UPDATE \"Devices\" set descricao = ? WHERE id = ?";
	try {
		PreparedStatement prep = con.prepareStatement(sql);
		prep.setInt(1, d.getID());
		System.out.println(prep.toString());
		prep.execute();
		prep.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
    }

    public void deletarDispositivo(Dispositivo d){
	String sql = "DELETE FROM \"Devices\" WHERE id = ?";
	try {
		PreparedStatement prep = con.prepareStatement(sql);
		prep.setInt(1, d.getID());
		System.out.println(prep.toString());
		prep.execute();
		prep.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
    }
	
    public List<Dispositivo> listarDispositivos(){
	String sql = "SELECT * FROM \"Devices\"";
	List<Dispositivo> list = null;
	try {
		PreparedStatement prep = con.prepareStatement(sql);
		System.out.println(prep.toString());
		ResultSet res = prep.executeQuery();
		list = new ArrayList<Dispositivo>();
		while(res.next()){
			Dispositivo temp = new Dispositivo();
			temp.setID(res.getInt("id"));
			temp.setDescricao(res.getString("login"));
			list.add(temp);
		}
		prep.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
    }
}
