package br.com.devmedia.webservice.model.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	private static EntityManagerFactory emf;

	private static EntityManager getEntityManager() {
		 if (emf == null) {
			emf = Persistence.createEntityManagerFactory("produtos");
		 }
		 return emf.createEntityManager();
	}
	
	public static void main(String[] args) {

		Produto produto1 = new Produto();
		produto1.setNome("Impressora");
		produto1.setQuantidade(24);
		
		Produto produto2 = new Produto();
		produto2.setNome("Teclado");
		produto2.setQuantidade(20);
		
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(produto1);
		em.persist(produto2);
		em.getTransaction().commit(); 
		
		em.close();
		emf.close();
	}

}
