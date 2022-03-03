package com.ilinesolution.sistema.modelo.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ilinesolution.sistema.modelo.dao.GenericaDao;

public class GenericaDaoImpl<T> implements GenericaDao<T>{

	private Class<T> entidad;
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema");
    protected EntityManager entityManager = emf.createEntityManager();

    public GenericaDaoImpl() {
        entityManager = emf.createEntityManager();
    }

    public GenericaDaoImpl(Class<T> entidad) {
        entityManager = emf.createEntityManager();
        this.entidad = entidad;
    }
    
    public T create(T objeto){
        this.entityManager.persist(objeto);
        return objeto;
    }
    
     public T read(Object id) {
        return this.entityManager.find(entidad, id);
    }

    public T update(T t) {
        return this.entityManager.merge(t);
    }

    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }
    
    public void beginTransaction(){
        if(!entityManager.getTransaction().isActive()){
            entityManager = emf.createEntityManager();
        }
        
        entityManager.getTransaction().begin();
    }
    
    public void rollback() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
     public void commit() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
        }
    }
    
      public void closeTransaction() {
        entityManager.close();
    }
      
       public void flush() {
        entityManager.flush();
    }
       
         public List<T> findAll() {
        /*javax.persistence.criteria.CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entidad));
      */
        return null;  // this.entityManager.createQuery(cq).getResultList();
    }

		@Override
		public void commitAndCloseTransaction() {
			// TODO Auto-generated method stub
			
		}

		
}
