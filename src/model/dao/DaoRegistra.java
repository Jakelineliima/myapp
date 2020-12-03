package model.dao;

import model.banco.Mysql;
import model.entidade.Usuario;

public class DaoRegistra {
	
	public boolean insereUsuario(Usuario usuario) {
		boolean retorno=false;
		
		String sql = " INSERT INTO usuario (nome, email, senha, celular) " +
				" VALUES ('" + usuario.getNome() + "','" + usuario.getEmail() +
				"','" + usuario.getSenha() + "','" + usuario.getCelular() + "')";
		             		
		System.out.println ("SQL no DAO: " + sql);
		
		Mysql mysql = new Mysql();
		if (mysql.carregaDriver()&& mysql.conecta()&& mysql.preparaComando()) {
			if(mysql.altera(sql)) {
				retorno = true;
			}
		}
		
		return retorno;
	}

}
