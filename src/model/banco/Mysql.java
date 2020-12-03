package model.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql {
    Connection conexao;
    Statement comando;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/bdprojeto?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "";
	
    public boolean carregaDriver() {
    	boolean resultado = false;
    	System.out.println ("Carrega driver: ");
        try {
			Class.forName(driver);
			resultado = true;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return resultado;
	}

    public boolean conecta() {
        boolean resultado = false;
        System.out.println ("Conecta: ");
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            resultado = true;
        } catch (SQLException ex) {
            System.out.println ("Erro na conexao: " + ex.toString());
        }        
        
        return resultado;
    }
    
    public boolean preparaComando() {
        boolean resultado = false;
        System.out.println ("Prepara comando: ");
        
        try {
            comando = conexao.createStatement();
            resultado = true;
        } catch (SQLException ex) {
            System.out.println ("Erro no comando: " + ex.toString());
        }
        
        return resultado;
    }
    
    public ResultSet consulta(String sql) {
        ResultSet resultado=null;
        System.out.println ("Consulta: ");
        
        try {
            resultado = comando.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println ("Erro no SQL: " + ex.toString() + "\n" + sql);
        }
        
        return resultado;
    }
    
    
    public boolean altera (String sql) {
        boolean resultado=false;
     
        System.out.println ("Altera:" + sql );
        try {
            int r = comando.executeUpdate(sql);
            if (r > 0) resultado=true;
        } catch (SQLException ex) {
            System.out.println ("Erro no SQL: " + ex.toString() + "\n" + sql);
        }
        return resultado;
    }
    
    

 

}
 