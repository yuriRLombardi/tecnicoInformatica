package model;

import java.time.LocalDate;
import java.util.ArrayList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class CafeteriaDAO {
	private EntityManagerFactory emf;
	public CafeteriaDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	public boolean inserir(String nome, String desc, double preco, String validade, String[] ingre, double taxa, Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		try {
			Produto produto = new Produto(0, nome, desc, preco, ingre, taxa, LocalDate.parse(validade),usuario);
			em.getTransaction().begin();
			em.persist(produto);
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
	public Produto procurarProduto(int id) {
		EntityManager em = emf.createEntityManager();
		Produto produto = null;
		try {
			produto = em.find(Produto.class, id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return produto;
	}
	public ArrayList<Produto> consulta(Usuario usuario) {
		ArrayList<Produto> cardapio = new ArrayList<Produto>();
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("from "+Produto.class.getName()+" where usuario = :u");
			query.setParameter("u", usuario);
			cardapio = (ArrayList<Produto>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return cardapio;
	}
	public boolean deletar(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			Produto produto = em.find(Produto.class, id);
			em.getTransaction().begin();
			em.remove(produto);
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

	public boolean modificar(int id,String nome, String desc, double preco, String validade, String[] ingre, double taxa, Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		try {
			Produto produto = new Produto(id, nome, desc, preco, ingre, taxa, LocalDate.parse(validade), usuario);
			em.getTransaction().begin();
			em.merge(produto);
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
