package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DaoLogin;

/**
 * Servlet implementation class ControllerLogin
 */
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		if (botao.equals("login")) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			String mensagem = "";
			
			DaoLogin dao = new DaoLogin();
			if (dao.validaLogin(email, senha)) {
				mensagem="Sucesso";
			} else {
				mensagem="Falha no Login";
			}
			
			PrintWriter saida = response.getWriter();
			saida.println ("<html>");
			saida.println ("	<body>");
			saida.println ("		<p> "  + mensagem + "</p>");
			saida.println ("	</body>");
			saida.println ("</html>");
			
			saida.flush();		
		}
	}

}
