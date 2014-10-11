package br.com.pompeusolutions.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pompeusolutions.entidades.Usuario;

public class UsuarioDAO {

	private Connection con = Conexao.getConnection();
	private PreparedStatement preparar;

	public void cadastrar(Usuario usuario) {
		// montar o sql
		String sql = "INSERT INTO USUARIO(nome,login,senha) VALUES (?,?,?)";
		
		try {

			preparar = con.prepareStatement(sql);
			preparar.setString(1, usuario.getNome());
			preparar.setString(2, usuario.getLogin());
			preparar.setString(3, usuario.getSenha());
			preparar.execute();
			preparar.close();
			System.out.println("Cadastrado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro na Query " + e.getMessage());
			// e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		// montar o sql
		String sql = "UPDATE USUARIO SET nome=?,login=?,senha=md5(?) WHERE id=?";
		// fun��o que execulta a query
		try {

			preparar = con.prepareStatement(sql);
			preparar.setString(1, usuario.getNome());
			preparar.setString(2, usuario.getLogin());
			preparar.setString(3, usuario.getSenha());
			preparar.setInt(4, usuario.getId());
			preparar.execute();
			preparar.close();
			// System.out.println("Atualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro na Query " + e.getMessage());
			// e.printStackTrace();
		}
	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() != 0) {
			alterar(usuario);
		} else {
			
			cadastrar(usuario);
		}
	}

	public void execluir(Usuario usuario) {
		// montar o sql
		String sql = "DELETE FROM USUARIO WHERE id=?";
		// fun��o que execulta a query
		try {
			preparar = con.prepareStatement(sql);
			preparar.setInt(1, usuario.getId());
			preparar.execute();
			preparar.close();
			//System.out.println("excluido");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro na Query " + e.getMessage());
			// e.printStackTrace();
		}
	}

	public List<Usuario> buscarTodos() {
		// montar o sql
		String sql = "SELECT * FROM USUARIO ORDER BY NOME";

		List<Usuario> lista = new ArrayList<Usuario>();// boto lista fora para
														// poder retornala
		// fun��o que execulta a query
		try {
			// sempre prepara o estado antes de pegar um resultado
			PreparedStatement preparar = con.prepareStatement(sql);
			// sempre que for fazer consulta usa executeQuery
			ResultSet resultado = preparar.executeQuery();

			while (resultado.next()) {

				Usuario usu = new Usuario();
				// pegar os dados
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				// usu.setSenha(resultado.getString("senha"));

				lista.add(usu); // add parar adicionar objetos a lista

			}
			preparar.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro na Query " + e.getMessage());
			// e.printStackTrace();
		}
		return lista;

	}
	public Usuario buscarPorId(int id) {
		// montar o sql
		String sql = "SELECT * FROM USUARIO WHERE id = ?";
		//List<Usuario> lista = new ArrayList<>();
		Usuario usuario = new Usuario();
		// glogal ao metodo

		// fun��o que execulta a query
		try {
			// sempre prepara o estado antes de pegar um resultado
			PreparedStatement preparar = con.prepareStatement(sql);
			// sempre que for fazer consulta usa executeQuery
			preparar.setInt(1, id);

			ResultSet resultado = preparar.executeQuery();

			while (resultado.next()) {
				//Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				//lista.add(usuario);
			}
			preparar.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro " + e.getMessage());
			// e.printStackTrace();
		}
		return usuario;

	}


	public List<Usuario> buscarPorNome(String nome) {
		// montar o sql
		String sql = "SELECT * FROM USUARIO WHERE NOME like ?";
		List<Usuario> lista = new ArrayList<>();
		// glogal ao metodo

		// fun��o que execulta a query
		try {
			// sempre prepara o estado antes de pegar um resultado
			PreparedStatement preparar = con.prepareStatement(sql);
			// sempre que for fazer consulta usa executeQuery
			preparar.setString(1, "%" + nome + "%");

			ResultSet resultado = preparar.executeQuery();

			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				lista.add(usuario);
			}
			preparar.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro " + e.getMessage());
			// e.printStackTrace();
		}
		return lista;

	}
	/**
	 * Metodo de Busca do Usuario e senha no banco 
	 * @param usuario receber um Objeto como parametro
	 * @return null quando n�o encontra ou um ponteiro do objeto usuario quando encontra
	 */
	public Usuario altenticar(Usuario usuario) {
		// montar o sql
		String sql = "SELECT * FROM USUARIO WHERE login = ? and senha = ?";
		Usuario usuarioRetorno = null;// referente ao retorno

		// fun��o que execulta a query
		try {
			// sempre prepara o estado antes de pegar um resultado
			PreparedStatement preparar = con.prepareStatement(sql);
			// sempre que for fazer consulta usa executeQuery
			preparar.setString(1, usuario.getLogin());
			preparar.setString(2, usuario.getSenha());

			ResultSet resultado = preparar.executeQuery();

			if (resultado.next()) {
				usuarioRetorno = new Usuario();
				usuarioRetorno.setId(resultado.getInt("id"));
				usuarioRetorno.setNome(resultado.getString("nome"));
				usuarioRetorno.setLogin(resultado.getString("login"));
				usuarioRetorno.setSenha(resultado.getString("senha"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return usuarioRetorno;

	}
}
