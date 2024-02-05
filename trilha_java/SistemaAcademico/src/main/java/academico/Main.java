package academico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		delete();
	}

	public static void create() {
		Estudante e1 = new Estudante(null, "Tõe", "toe@tutu", "111111");
		Estudante e2 = new Estudante(null, "Lia", "lia@tutu", "222222");
		Estudante e3 = new Estudante(null, "Tuca", "tuca@tutu", "333333");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static void read() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
        EntityManager em = emf.createEntityManager();
        Estudante e1 = em.find(Estudante.class, 8);
        System.out.println(e1);
        em.close();
        emf.close();
	}
	
	public static void update() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
        EntityManager em = emf.createEntityManager();
        Estudante e1 = em.find(Estudante.class, 8);
        e1.setMatricula("444444");
        em.getTransaction().begin();
        em.merge(e1);
        em.getTransaction().commit();
        em.close();
        emf.close();	
	}
	
	public static void delete() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
        EntityManager em = emf.createEntityManager();
        Estudante e1 = em.find(Estudante.class, 8);
        em.getTransaction().begin();
        em.remove(e1);
        em.getTransaction().commit();
        em.close();
        emf.close();
	}
}
