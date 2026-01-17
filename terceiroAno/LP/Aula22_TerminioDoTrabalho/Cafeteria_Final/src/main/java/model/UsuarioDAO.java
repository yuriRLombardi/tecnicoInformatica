package model;


import java.util.ArrayList;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class UsuarioDAO {
	private EntityManagerFactory emf;

	public UsuarioDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	
	public boolean inserir(String login, String senha, String nome, String cnpj, String email, String telefone) {
		EntityManager em = emf.createEntityManager();
		try {
			Usuario usuario = new Usuario(login, senha, nome, cnpj, email, telefone);
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
		
	}
	
	public Usuario procurarUsuario(String login) {
		EntityManager em = emf.createEntityManager();
		Usuario usuario = null;
		
		try {
			usuario = em.find(Usuario.class, login);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return usuario;
	}
	public boolean deletarUsuario(String login) {
		EntityManager em = emf.createEntityManager();
		try {
			Usuario usuario = em.find(Usuario.class, login);
			Query query = em.createQuery("from "+Produto.class.getName()+" where usuario = :u");
			query.setParameter("u", usuario);
			ArrayList<Produto> produtos = (ArrayList<Produto>) query.getResultList();
			em.getTransaction().begin();
			for(Produto produto: produtos) {
				em.remove(produto);
			}	
			em.remove(usuario);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
}
