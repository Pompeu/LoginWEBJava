package br.com.pompeusolutions.text;

import java.util.List;

import br.com.pompeusolutions.entidades.Usuario;
import br.com.pompeusolutions.jdbc.UsuarioDAO;

public class TextDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*cadastrar();
		atualizar();
		excluir();
		resultado();
		logar();
		Bnome();
		buscaId(16);*/

	}
/*
	private static void atualizar() {
		Usuario usuA = new Usuario(1, "Abadio", "1234", "Ababa");
		UsuarioDAO usd = new UsuarioDAO();
		usd.alterar(usuA);
	}

	private static void cadastrar() {

		Usuario usu = new Usuario("Pompeu", "888", "Pompeulimp");
		UsuarioDAO usd = new UsuarioDAO();
		usd.cadastrar(usu);

	}

	private static void excluir() {

		Usuario usuE = new Usuario(11);
		UsuarioDAO usd = new UsuarioDAO();
		usd.execluir(usuE);

	}

	private static void resultado() {
		UsuarioDAO usd = new UsuarioDAO();
		List<Usuario> listaResultado = usd.buscarTodos();

		for (Usuario usuario : listaResultado) {
			System.out.println(usuario.getId() + " " + usuario.getNome() + " "
					+ usuario.getLogin());
		}

	}
	private static void buscaId(int id){
		
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario = usuDao.buscarPorId(id);
		
		
			System.out.println(usuario.getId() + " " + usuario.getNome() + " "
					+ usuario.getLogin()+" "+usuario.getSenha());
		
		
	}
	
	private static void Bnome(){
				
		UsuarioDAO usu = new UsuarioDAO();
		List<Usuario> listaResultado = usu.buscarPorNome("Pompeu");
		
		for (Usuario usuario : listaResultado) {
			System.out.println(usuario.getId() + " " + usuario.getNome() + " "
					+ usuario.getLogin()+" "+usuario.getSenha());
		}
		
	}
	
	private static void logar(){
		Usuario usuario = new Usuario("Pompeulimp", "888");	
		
		UsuarioDAO usu = new UsuarioDAO();
		System.out.println(usu.altenticar(usuario));
	}*/
}
