package br.com.pompeusolutions.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pompeusolutions.entidades.Usuario;
import br.com.pompeusolutions.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioControler
 */
@WebServlet("/usucontroler.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Chamando Metodo doGet");
		// pegando paremetro acação da tela
		UsuarioDAO usoDao = new UsuarioDAO();
		Usuario usu = new Usuario();
		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("exc")) {
			// pega parametro id da ela
			String id = request.getParameter("id");
			usu.setId(Integer.parseInt(id));
			usoDao.execluir(usu);
			response.sendRedirect("usucontroler.do?acao=list");

		}

		if (acao != null && acao.equals("alt")) {
			// pega parametro id da tela
			String id = request.getParameter("id");
			// faz a busca por id
			usu = usoDao.buscarPorId(Integer.parseInt(id));
			// seta o objeto id no request
			request.setAttribute("usuario", usu);
			// encaminha objeto usu ao Dispatecher
			RequestDispatcher saida = request
					.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);

		}

		if (acao != null && acao.equals("cad")) {

			usu = new Usuario(0, "", "", "");

			// seta o objeto id no request
			request.setAttribute("usuario", usu);
			// encaminha objeto usu ao Dispatecher
			RequestDispatcher saida = request
					.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);

		}

		if (acao != null && acao.equals("list")) {

			List<Usuario> lista = usoDao.buscarTodos();
			/* requisitando a JPS */
			request.setAttribute("lista", lista);

			/* escanhar para jsp */

			RequestDispatcher saida = request
					.getRequestDispatcher("listausuario.jsp");

			saida.forward(request, response);
		}
		/*
		 * String htmlSaida = "<html> <body> <table border='1'" +
		 * "<tr> <td>id</td> <td>nome</td> <td>Login</td> <td>Senha </td></tr>"
		 * ;
		 * 
		 * for (Usuario usu : lista) { htmlSaida += "<tr> <td>" + usu.getId() +
		 * "</td>" + " <td>" + usu.getNome() + "</td> <td>" + usu.getLogin() +
		 * "</td>" + " <td>" + usu.getSenha() + " </td></tr>"; }
		 * 
		 * htmlSaida += "</table></body></html>";
		 * 
		 * PrintWriter saida = response.getWriter(); saida.println(htmlSaida);
		 */
		/* jsp começa aqui usando conceito de encaminhamento */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Chamando metodos Post");
		/* metodo getParameter caputa parametros do html */
		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtname");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		/* esse ponto ele pega os dados da tela e os carregão o objeto usuario */

		Usuario usuario = new Usuario();

		if (id != "0" && id != null && id != "") {// tratamento exessão do ID
			usuario.setId(Integer.parseInt(id));
		}
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		/* aqui começa a persistencia no banco atravez do UsuarioDao */
		UsuarioDAO usuarioDao = new UsuarioDAO();
		// esse metodo é quem define se cadastro ou se altero
		usuarioDao.salvar(usuario);
		// saida do nevagdor
		PrintWriter saida = response.getWriter();
		saida.print("Salvo !!!!");

	}

}
