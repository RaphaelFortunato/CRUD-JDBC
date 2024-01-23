package meu_crud_jdbc.meu_crud_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConncetion;
import dao.UsuarioDAO;
import model.Usuario;

public class TesteBanco {

	
	
	@Test
	public void insertBanco() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();		
		usuario.setNome("Luiz");
		usuario.setEmail("luiz@luiz.com");
		
		usuarioDAO.salvar(usuario);
		System.out.println("Registro inserido com sucesso");
		
	}
	
	@Test
	public void consultarBanco() {
		try {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
					
			List<Usuario> list = usuarioDAO.listaDeUsuarios();
			for (Usuario usuario : list) {
				System.out.println(usuario);
				System.out.println("----------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void consultaIdBanco() {
		
		try {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			Usuario consulta = usuarioDAO.consultaUsuarioId(28L);
			System.out.println(consulta);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void atualizarBanco() {
		try {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuarioBanco = usuarioDAO.consultaUsuarioId(28L);
			
			usuarioBanco.setNome("Marcos");
			usuarioBanco.setEmail("marcos@marcos.com");
			
			usuarioDAO.atualizarUsuario(usuarioBanco);
			
			
			System.out.println(usuarioBanco.getNome());
			System.out.println(usuarioBanco.getEmail());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void deletarNoBanco() {
		try {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.deletarDoBanco(28L);
			
			System.out.println("Usuário excluído com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
