package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.banco.Mysql;


public class DaoLogin {
	
	public boolean validaLogin(String email, String senha) {
		boolean resultado = false;
		
		String sql = "SELECT * FROM usuario WHERE email='" + email + 
				                       "' AND     senha='" + senha + "'";
		    
		Mysql mysql = new Mysql();
		if (mysql.carregaDriver() && mysql.conecta() && mysql.preparaComando()) {
			
			ResultSet r = mysql.consulta(sql);
			if (r != null) {	
				try {
					if (r.next()) resultado=true;
				} catch (SQLException ex) {
					System.out.println ("Erro no ValidaLogin");
				}
			}
		}
		
		return resultado;
	}

}
