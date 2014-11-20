package br.ufba.dcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufba.dcc.jdbc.ConectionFactory;
import br.ufba.dcc.model.Usuario;

public class UsuarioDAO {
	
	private Connection con;
	
	public UsuarioDAO(){
		con = ConectionFactory.getPostgresConnection();
		
	}
	
	public void cadastrarUsuario(Usuario usuario){
		String sql = "INSERT INTO \"Usuarios\" (login,senha) VALUES (?, ?)";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(2, usuario.getLogin());
			prep.setString(3, usuario.getSenha());
			System.out.println(prep.toString());
			prep.execute();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarUsuario(Usuario usuario){
		String sql = "UPDATE \"Usuarios\" set login = ?, senha = ? WHERE login = ?";
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
	
	public void deletarUsuario(Usuario usuario){
		String sql = "DELETE FROM \"Usuarios\" WHERE login = ?";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, usuario.getLogin());
			System.out.println(prep.toString());
			prep.execute();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> listarUsuarios(){
		String sql = "SELECT * FROM \"Usuarios\"";
		List<Usuario> list = null;
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			System.out.println(prep.toString());
			ResultSet res = prep.executeQuery();
			list = new ArrayList<Usuario>();
			while(res.next()){
				Usuario temp = new Usuario();
				temp.setId(res.getInt("id"));
				temp.setLogin(res.getString("login"));
				temp.setSenha(res.getString("senha"));
				list.add(temp);
			}
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Usuario> listarUsuarios(String col, int value){
		String sql = "SELECT * FROM \"Usuarios\" WHERE "+ col +" = ?";
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, value);
			System.out.println(prep.toString());
			ResultSet res = prep.executeQuery();
			List<Usuario> list = new ArrayList<Usuario>();
			while(res.next()){
				Usuario temp = new Usuario();
				temp.setId(res.getInt("id"));
				temp.setLogin(res.getString("login"));
				temp.setSenha(res.getString("senha"));
				list.add(temp);
			}
			prep.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> listarUsuarios(String col, String value){
		String sql = "SELECT * FROM \"Usuarios\" WHERE "+ col +" = ?";
		Usuario temp = null;
		List<Usuario> list = null;
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, value);
			System.out.println(prep.toString());
			ResultSet res = prep.executeQuery();
			list = new ArrayList<Usuario>();
			while(res.next()){
				temp = new Usuario();
				temp.setId(res.getInt("id"));
				temp.setLogin(res.getString("login"));
				temp.setSenha(res.getString("senha"));
				list.add(temp);
			}
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Boolean autenticarUsuario(Usuario usuario){
		String sql = "SELECT * FROM \"Usuarios\" WHERE login = ? and senha = ?";
		Boolean bol = new Boolean(false);
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, usuario.getLogin());
			prep.setString(2, usuario.getSenha());
			System.out.println(prep.toString());
			ResultSet res = prep.executeQuery();
			bol = res.next();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bol;
	}
	
}
