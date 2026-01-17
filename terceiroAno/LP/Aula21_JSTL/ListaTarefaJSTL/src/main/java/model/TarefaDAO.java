package model;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class TarefaDAO {
	private EntityManagerFactory emf;
		
	public TarefaDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public boolean inserirTarefa(String descricao, int prioridade, Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		try {
			Tarefa tarefa = new Tarefa(descricao, prioridade, usuario);
			em.getTransaction().begin();
			em.persist(tarefa);
			em.getTransaction().commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	public Tarefa procurarTarefa(int id) {
		EntityManager em = emf.createEntityManager();
		Tarefa tarefa = null;
	
		try {
			tarefa = em.find(Tarefa.class, id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return tarefa;
	}
	public ArrayList<Tarefa> consultarTarefas(Usuario usuario) {
		ArrayList<Tarefa> listaTarefas = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("from "+Tarefa.class.getName()+" where usuario = :u");
			query.setParameter("u", usuario);
			listaTarefas = (ArrayList<Tarefa>) query.getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return listaTarefas;
	}
	

	public boolean excluirTarefa(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Tarefa tarefa = em.find(Tarefa.class, id);
			em.getTransaction().begin();
			em.remove(tarefa);
			em.getTransaction().commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}

	public boolean modificarTarefa(int id, String descricao, int prioridade, Usuario usuario) {
		EntityManager em = emf.createEntityManager();

		try {
			Tarefa tarefa = new Tarefa(id,descricao,prioridade, usuario);
			em.getTransaction().begin();
			em.merge(tarefa);
			em.getTransaction().commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
}