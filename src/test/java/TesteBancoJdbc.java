

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() throws Exception {
		
		UserPosDAO userPosDao = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("Maria Jose");
		userposjava.setEmail("MariaJose@gmail.com");
		
		userPosDao.salvar(userposjava);
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			List<Userposjava> list = dao.listar();
			
			for(Userposjava userposjava : list) {
				System.out.println(userposjava);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(1L);
			System.out.println(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjavaNoBanco = dao.buscar(4L);
			
			userposjavaNoBanco.setNome("Nome atulizado");
			userposjavaNoBanco.setEmail("Email atulizado");
			
			dao.atualizar(userposjavaNoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {

		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(6L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initInsertTelefone() {
		
		Telefone telefone = new Telefone();
		
		telefone.setNumero("(13) 99911-8766");
		telefone.setTipo("Fixo");
		telefone.setUsuario(3L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void initCarregaFonesUser() {
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaTelefoneUsuario(1L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
		}
	}


}