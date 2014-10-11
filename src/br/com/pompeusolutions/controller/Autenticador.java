package br.com.pompeusolutions.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.pompeusolutions.entidades.Usuario;
import br.com.pompeusolutions.jdbc.UsuarioDAO;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet("/autenticador.do")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao = request.getSession(false);
		
		if(sessao != null){
			
			sessao.invalidate();//termina a sessap
		}
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		//constroi objeto usuario para consulta
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuRetorno = usuDao.altenticar(usuario);
		
		if(usuRetorno != null){
			//criando httpsessao
			
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(3000);//configurar o tempo da sess�o
			sessao.setAttribute("usuLogado", usuRetorno);
			//encaminha  ao index.jsp ou sistema
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.html");
		}
	}

}
