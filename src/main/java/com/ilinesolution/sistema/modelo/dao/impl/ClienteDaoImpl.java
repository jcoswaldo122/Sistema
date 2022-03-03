package com.ilinesolution.sistema.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ilinesolution.sistema.modelo.dao.ClienteDao;
import com.ilinesolution.sistema.modelo.entidades.Cliente;

public class ClienteDaoImpl extends GenericaDaoImpl<Cliente> implements ClienteDao{

	@Override
	public void insertarCliente(Cliente cliente) {
		
		try {
			this.beginTransaction();
			this.create(cliente);
			this.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
	}

	@Override
	public void modificarCliente(Cliente cliente) {
		try {
			this.beginTransaction();
			this.update(cliente);
			this.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		try {
			this.beginTransaction();
			this.delete(cliente);
			this.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.rollback();
		}
	
	}

	@Override
		//Lista todos los elementos de una tabla 
		public List<Cliente> listaCliente() {
		
		//CriteriaQuery<Cliente> cliente = this.entityManager.createQuery("Select from cli Cliente cli", Cliente.class);
	        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
	      //--------------------Consulta
	        //2 Definir el Query lo que deseo que retorne 
	        CriteriaQuery<Cliente> c = cb.createQuery(Cliente.class);
	        //3.- Definir la "Tabla de la consulta"
	        Root<Cliente> cliente = c.from(Cliente.class);
	        //4.- Seleccionar los atributos (Todos los atibutos )
	        c.select(cliente);//Select * 
	        //--------------Fin de consulta 
	        return this.entityManager.createQuery(c).getResultList();
	    }

	@Override
	public Cliente buscarClienteCod(int codCliente) {
		//selec * fro m cliente where codCliente
		CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> c = cb.createQuery(Cliente.class);
		Root<Cliente> cliente = c.from(Cliente.class);
		c.select(cliente).where(cb.equal(cliente.get("codCliente"), codCliente));
		return this.entityManager.createQuery(c).getSingleResult();			
	}
	
	@Override
	//Buscar cliente por id o cualquiera 
	public Cliente buscarClienteId(int codCliente) {
		
		//Select * from cliente where codCliente= ? (A comparar con qeu comparar )
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> c= cb.createQuery(Cliente.class);
		Root<Cliente> cliente = c.from(Cliente.class);
		c.select(cliente).where(cb.equal(cliente.get("codCliente"), codCliente));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	
	
	@Override
	//Lista campos Especificas como id y nombre 
	public List<Tuple> listarIdNombre(){
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c = cb.createTupleQuery();//Solo columnas especificas
		Root<Cliente> cliente = c.from(Cliente.class);
		c.select(cb.tuple(cliente.get("nombre"),cliente.get("direccion")));
		return this.entityManager.createQuery(c).getResultList();
	}
	
	
	
	   @Override
	    public Cliente getClienteId(int codCliente) { 
		   
			   TypedQuery<Cliente>  sql=this.entityManager.createQuery("Select cli From Cliente cli where cli.codCliente=:codCliente",Cliente.class ).setParameter("codCliente", codCliente);
			   return sql.getSingleResult();
	 
	    }
	   @Override
	   //validacion de imei no se repita validar en algun lado 
	   public Cliente buscarClienteEmail(String emailCliente) {
		   CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<Cliente> c= cb.createQuery(Cliente.class);
			Root<Cliente> cliente = c.from(Cliente.class);
			//c.select(cliente).where(cb.equal(cliente.get("email"), emailCliente),and(cliente.get("estado"),1));
			return this.entityManager.createQuery(c).getSingleResult();
	   }


}

