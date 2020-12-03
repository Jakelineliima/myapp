package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DaoRegistra;
import model.entidade.Usuario;

/**
 * Servlet implementation class ControllerRegistra
 */
public class ControllerRegistra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRegistra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		if (botao.equals("registrar")) {

			String nome    = request.getParameter("nome");
			String email   = request.getParameter("email");
			String senha   = request.getParameter("senha");
			String celular = request.getParameter("celular");
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setCelular(celular);
			
			String mensagem=" teste";
			System.out.println ("Nome: " + nome);
			
			DaoRegistra dao = new DaoRegistra();
			if (dao.insereUsuario(usuario)) {
				mensagem = "Usuario Inserido";
			} else {
				mensagem = "Erro na Inserção";
			}
			
			
			
			// apenas para teste
			PrintWriter saida = response.getWriter();
			String html = "<html>";
			html       += "   <body>";
			html       += "      <p> " + mensagem + " </p>";
			html       += "   </body>";
			html       += "</html>";
			
			saida.println(html);
			saida.flush();
			
		}
	}

}
